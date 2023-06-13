package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try{
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        }catch(IOException ex){
            ConsoleHelper.writeMessage(ex.getMessage());
            clientConnected = false;
        }
    }
    public void run() {
        Client.SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

                while (clientConnected) {
                    String text;
                    if (!(text = ConsoleHelper.readString()).equals("exit")) {
                        if (shouldSendTextFromConsole()) {
                            sendTextMessage(text);
                        }
                    }else {
                        return;
                    }
                }
            }
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        } catch (InterruptedException ex) {
            ConsoleHelper.writeMessage("Ups..");
        }
    }
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("участник с именем %s присоединился к чату.", userName));
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("участник с именем %s покинул чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }}
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = Client.this.connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message message = Client.this.connection.receive();
                if(message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }else if(message.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        public void run() {
            try {
                Client.this.connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);

            }
        }
    
        }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
