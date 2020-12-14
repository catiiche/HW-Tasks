package com.itmo.shkuratova.coursework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;

/**
 * class Client
 *
 * This class represents a client which can connect to a server and interact with:
 * 1. reads messages from the console, creates Message objects and sends them to the server
 * 2. receives incoming messages and prints to the console
 * @see MultiThreadServer
 *
 * @author Kate Shkuratova
 * @version 1.1
 */

public class Client implements Runnable {
    private String ip;
    private int port;
    private static Socket socket;
    private String threadName;
    private static Connection connection;

    public Client(String ip, int port) {
        this.ip = Objects.requireNonNull(ip);
        this.port = Objects.requireNonNull(port);
        try {
            this.socket = new Socket(ip, port);
            connection = new Connection(this.socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Properties properties = Connection.getProperties();
        Client client = new Client(properties.getProperty("ip"), Integer.valueOf(properties.getProperty("port")));
        try {
            System.out.println("Поток на отправку");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите ваш логин");
                String user = reader.readLine();
                while (true) {
                    System.out.println("Введите сообщение");
                    String text = reader.readLine();
                    Message message = new Message(user, text);
                    connection.sendMessage(message);
//                    Thread recieve = new Thread();
//                    recieve.start();
                    Message messageRecieve = null;
                    try {
                        byte[] buff = new byte[MultiThreadServer.BUFFER_SIZE];
                        connection.input.read(buff);
                        messageRecieve = connection.readMessage();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println(messageRecieve.getText());
                }
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    private void getMessage(Message message) {
        System.out.println();

    }


    @Override
    public void run() {
        System.out.println("ПОлучаем");
        Message message = null;
        try {
            message = connection.readMessage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(message.getText());
    }
}
















/*
        try {
            Thread send = new Thread(() -> {
                //System.out.println("Поток на отправку стартовал");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите ваш логин");
                String user = null;
                try {
                    user = reader.readLine();
                    while (true) {
                        System.out.println("Введите сообщение");
                        String text = reader.readLine();
                        Message message = new Message(user, text);
                        connection.sendMessage(message);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            send.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/



/*
    public void run() {
        try {
            if (this.threadName.equalsIgnoreCase("send")) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите ваш логин");
                String user = reader.readLine();

                while (true) {
                    System.out.println("Введите сообщение");
                    String text = reader.readLine();
                    Message message = new Message(user, text);
                    connection.sendMessage(message);
                }
            } else if (this.threadName.equalsIgnoreCase("receive")) {

                Message message = connection.readMessage();
                System.out.println(message.getText());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
 */