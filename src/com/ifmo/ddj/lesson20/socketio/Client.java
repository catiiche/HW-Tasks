package com.ifmo.ddj.lesson20.socketio;

import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in); // создаем в конструкторе, чтобы не занимал память до вызова объекта
    }

    public static void main(String[] args) {
        //Properties properties = null;
        Properties properties = Connection.getProperties();
        try {
            new Client(properties.getProperty("ip"), Integer.valueOf(properties.getProperty("port"))).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        String name = scanner.nextLine();
        String message;
        while (true) {
            System.out.println("Введите сообщение");
            message = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection =
                     new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            if (fromServer.getText().startsWith("/")) {
                System.out.println(fromServer.getText().substring(1));
            } else System.out.println("от сервера: " + fromServer);
        }
    }
}

// если необходимо запустить параллельно несколько клиентов: client -> edit configuration -> allow parallel run
