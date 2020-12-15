package com.itmo.shkuratova.coursework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Properties;

/**
 * class Client
 * <p>
 * This class represents a client which can connect to a server and interact with:
 * 1. reads messages from the console, creates Message objects and sends them to the server
 * 2. receives incoming messages and prints to the console
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see MultiThreadServer
 */

public class Client {
    private String ip;
    private int port;

    public Client(String ip, int port) {
        this.ip = Objects.requireNonNull(ip);
        this.port = Objects.requireNonNull(port);
    }

    public static void main(String[] args) {
        Properties properties = Connection.getProperties();
        Client client = new Client(properties.getProperty("ip"), Integer.valueOf(properties.getProperty("port")));
        client.start();
    }

    public void start() {
        try {
            Socket socket = new Socket(ip, port);
            Connection connection = new Connection(socket);
            Thread writer = new Thread(() -> {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите логин");
                String user = null;
                try {
                    user = reader.readLine();

                    String text;
                    while (true) {
                        System.out.println("Введите сообщение. Для выхода введите exit");
                        text = reader.readLine();
                        Message message = new Message(user, text);
                        if ("exit".equalsIgnoreCase(text)) {
                            System.out.println("exit");
                            connection.close();
                            break;
                        }
                        connection.sendMessage(message);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            });
            System.out.println("return");
            Thread reader = new Thread(() -> {
                while (true) {
                    Message messageFromServer;
                    try {
                        try {
                            messageFromServer = connection.readMessage();
                            System.out.println(messageFromServer);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            connection.close();
                            break;
                        } catch (IOException a) {
                            a.printStackTrace();
                        }
                    }

                }

            });
            writer.start();
            reader.start();
            try {
                writer.join();
                reader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
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
    } */
















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