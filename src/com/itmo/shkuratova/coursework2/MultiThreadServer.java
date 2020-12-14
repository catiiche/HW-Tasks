package com.itmo.shkuratova.coursework2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiThreadServer implements Runnable {
    private Socket clientSocket;
    public static ConcurrentHashMap<Integer, InetAddress> mapConnection = new ConcurrentHashMap<>();
    private static LinkedBlockingQueue<Message> messagesContainer = new LinkedBlockingQueue<>(500);
    public static final int BUFFER_SIZE = 256;

    public MultiThreadServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        Properties properties = Connection.getProperties();
        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("port")))) {
            while (true) {
                Socket socket = serverSocket.accept(); // client connected
                socket.getInetAddress();
                new Thread(new MultiThreadServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Connection connection = new Connection(clientSocket);
            Thread reader = new Thread(new ServerReader(connection));
            reader.start();
//            Thread writer =new Thread(new ServerWriter(connection));
//            writer.start();;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public class ServerReader implements Runnable {
        private Connection connection;

        public ServerReader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            System.out.println("New Connection " + MultiThreadServer.this.clientSocket.getInetAddress() + ": " + MultiThreadServer.this.clientSocket.getPort());
            try {
                while (true) {
                    byte[] buff = new byte[BUFFER_SIZE];
                    connection.input.read(buff);
                    Message message = connection.readMessage();
                    message.setSocket(MultiThreadServer.this.clientSocket);
                    messagesContainer.put(message);
                    mapConnection.putIfAbsent(MultiThreadServer.this.clientSocket.getPort(), MultiThreadServer.this.clientSocket.getInetAddress());
                    System.out.println("ПОлученное сообщение" + message.getText());
                    Thread writer = new Thread(new ServerWriter(connection));
                    writer.start();
                    ;
                }
            } catch (ClassNotFoundException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class ServerWriter implements Runnable {

        private Connection connection;

        public ServerWriter(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Message message;
                    if (!MultiThreadServer.this.messagesContainer.isEmpty()) {
                        message = Message.getMessage(MultiThreadServer.this.messagesContainer.peek());
//                        message = new Message(MultiThreadServer.this.messagesContainer.peek().getUser(), MultiThreadServer.this.messagesContainer.peek().getText());
                        System.out.println(message.getText() + "   " + message.getUser());
                    } else
                        message = new Message("server", "Утеряно " + MultiThreadServer.this.messagesContainer.size());
                    //Message message = new Message("server" , "получи");
//                    System.out.println("Message на отправку " + message.getText() + " socket: " + message.getSocket().getPort());

//                    for (Integer port : mapConnection.keySet()) {
//                        if (port == message.getSocket().getPort() && mapConnection.get(port).equals(message.getSocket().getInetAddress().toString())) {
//                            continue;
//                        }
//                    }
                    connection.sendMessage(message);
                    messagesContainer.remove(message);

                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
        }
    }
}








