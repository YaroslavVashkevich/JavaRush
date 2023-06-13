package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            try {
                super.clientMainLoop();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
        }
        @Override
        protected void processIncomingMessage(String message){

            if(message.contains(":")) {
                String userName = message.substring(0, message.indexOf(": "));
                String request = message.substring(message.indexOf(":") + 2);
                SimpleDateFormat dateFormat = null;

                switch (request) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                }
                if (dateFormat != null) {
                    sendTextMessage(String.format("Информация для %s: %s", userName, dateFormat.format(Calendar.getInstance().getTime())));
                }
            }
            ConsoleHelper.writeMessage(message);
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
