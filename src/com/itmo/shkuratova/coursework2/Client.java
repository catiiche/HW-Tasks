package com.itmo.shkuratova.coursework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;

/**
 * class Client
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
                        if (connection.getSocket().isClosed()) break;
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
            Thread reader = new Thread(() -> {
                while (true) {
                    if (connection.getSocket().isClosed()) break;
                    Message messageFromServer;
                    try {
                        try {
                            messageFromServer = connection.readMessage();
                            System.out.println(messageFromServer);
                        } catch (ClassNotFoundException e) {
                            break;
                        }
                    } catch (IOException e) {

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

