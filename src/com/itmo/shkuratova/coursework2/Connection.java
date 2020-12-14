package com.itmo.shkuratova.coursework2;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Connection implements AutoCloseable {
    private Socket socket;
    public ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket; // общий для клиента и сервера
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inStream = Connection.class.getClassLoader()
                .getResourceAsStream("ClientServer.properties")) {
            properties.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void sendMessage(Message message) throws IOException {
        output.writeObject(message);
        output.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) input.readObject();
    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}

