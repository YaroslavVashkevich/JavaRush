package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.USER_NAME) {
                    if (receiveMessage.getData() != null && !receiveMessage.getData().isEmpty()) {
                        if (!connectionMap.containsKey(receiveMessage.getData())) {
                            connectionMap.put(receiveMessage.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return receiveMessage.getData();
                        }
                    }
                }
            }
        }
        private void notifyUsers(Connection connection, String userName)throws IOException{
            for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
                if(!map.getKey().contains(userName)) {
                    Message message = new Message(MessageType.USER_ADDED, map.getKey());
                    connection.send(message);
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            ConsoleHelper helper = null;
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT) {
                    Message newMessage = new Message(message.getType(), String.format("%s: %s", userName, message.getData()));
                    sendBroadcastMessage(newMessage);
                }helper.writeMessage("Something wrong!");
            }
        }
        public void run(){
            String userName = null;
            try {
                System.out.println(socket.getRemoteSocketAddress());
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (Exception ex) {
                ex.printStackTrace();
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
        }

    }
    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            try {
                map.getValue().send(message);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }}

    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        System.out.println("Write port number:");
        int port = consoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server running..");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }catch (IOException ex){
            ex.getMessage();
        }
    }
}
