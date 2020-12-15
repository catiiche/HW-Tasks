package com.itmo.shkuratova.coursework2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * class MultiThreadServer
 * <p>
 * This class sends the received message to all connected clients,
 * except sender
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see ServerReader
 * @see ServerWriter
 * @see Client
 */

public class MultiThreadServer {
    private CopyOnWriteArraySet<Connection> clientSocket = new CopyOnWriteArraySet<>();
    private ArrayBlockingQueue<Message> messagesContainer = new ArrayBlockingQueue<>(50, true);

    public static void main(String[] args) {
        MultiThreadServer server = new MultiThreadServer();
        try {
            server.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException, ClassNotFoundException {
        Properties properties = Connection.getProperties();
        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("port")))) {
            System.out.println("Server started");

            new Thread(new MultiThreadServer.ServerWriter(clientSocket, messagesContainer)).
                    start();
            while (true) {
                Socket socket = serverSocket.accept(); // client connected
                Connection connection = new Connection(socket);
                clientSocket.add(connection);
                System.out.println("New client: " + socket);
                System.out.println(clientSocket);

                new Thread(new MultiThreadServer.ServerReader(connection, clientSocket, messagesContainer)).
                        start();
            }
        }
    }

    public class ServerReader implements Runnable {
        private Connection connection;

        public ServerReader(Connection connection,
                            CopyOnWriteArraySet<Connection> clientSocket,
                            ArrayBlockingQueue<Message> messagesContainer) {
            this.connection = Objects.requireNonNull(connection);
            MultiThreadServer.this.clientSocket = clientSocket;
            MultiThreadServer.this.messagesContainer = messagesContainer;
        }

        @Override
        public void run() {
            while (true) {
                Message clientMessage = null;
                try {
                    clientMessage = connection.readMessage();
                    clientMessage.setSocket(connection.getSocket());
                    System.out.println("Принято сообщение: " + clientMessage.getText() + " от " + clientMessage.getUser());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    try {
                        connection.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                }
                if (clientMessage == null) {
                    MultiThreadServer.this.clientSocket.remove(connection);
                    System.out.println("Client disconnected: " + connection);
                    break;
                } else if ("exit".equalsIgnoreCase(clientMessage.getText())) {
                    MultiThreadServer.this.clientSocket.remove(connection);
                    System.out.println("Client disconnected: " + connection);
                    break;
                }
                try {
                    messagesContainer.put(clientMessage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ServerWriter implements Runnable {

        public ServerWriter(CopyOnWriteArraySet<Connection> clientSocket, ArrayBlockingQueue<Message> messagesContainer) {
            MultiThreadServer.this.clientSocket = clientSocket;
            MultiThreadServer.this.messagesContainer = messagesContainer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Message messageFromContainer = messagesContainer.take();
                    for (Connection connection : clientSocket) {
                        if (!(connection.getSocket().toString().contains(String.valueOf(messageFromContainer.getSocket().getPort())))) {
                            connection.sendMessage(messageFromContainer);
                        }
                    }

                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}








