package com.ifmo.ddj.lesson20.socketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Properties;

public class SimpleServer {
    private Connection connection;
    private int count = 0;
    private static final long serialVersionID = 1L;

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
    }

    public void start() throws IOException, ClassNotFoundException {
        // ожидание клиента
        //Properties properties = null;
        Properties properties = Connection.getProperties();
        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("port")))) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept(); // принятие клиента, установка соединения
                connection = new Connection(socket);
                SimpleMessage message = connection.readMessage();
                LocalTime time = LocalTime.now();
                System.out.println(time);
                count++;
                System.out.println(message);
                String commandMessage = this.readMessage(message, time);
                if (Objects.isNull(commandMessage))
                    connection.sendMessage(SimpleMessage.getMessage("server", "received"));
                else connection.sendMessage(SimpleMessage.getMessage("server", commandMessage));
            }
        }
    }

    public String readMessage(SimpleMessage message, LocalTime time) {
        String command = message.getText().substring(1);
        if (Commands.HELP.toString().equalsIgnoreCase(command))
            return "/command: /" + Commands.HELP.toString().toLowerCase() + ". Available commands: " + help();
        if (Commands.COUNT.toString().equalsIgnoreCase(command))
            return "/command: /" + Commands.COUNT.toString().toLowerCase() + " Number of connections " + getCount();
        if (Commands.PING.toString().equalsIgnoreCase(command))
            return "/command: /"
                    + Commands.PING.toString().toLowerCase()
                    + " Current ping: "
                    + ping(message, time)
                    + " milliseconds";
        return null;
    }

    public String help() {
        StringBuilder sb = new StringBuilder();
        for (Commands value : Commands.values()) {
            sb.append("/").append(value.toString().toLowerCase()).append(", ");
        }
        return sb.toString();
    }

    public int getCount() {
        return count;
    }

    public long ping(SimpleMessage message, LocalTime time) {
        return ChronoUnit.MICROS.between(time, message.getDateTime().toLocalTime());
    }
}
// ip 127.0.0.1 : 8090
// сначала запускаем сервер, потом клиента