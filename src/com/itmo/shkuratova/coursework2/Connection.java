package com.itmo.shkuratova.coursework2;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;

/**
 * class Connection
 * <p>
 * This class for writing and reading from connections
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Client
 * @see MultiThreadServer
 */

public class Connection implements AutoCloseable {
    private Socket socket;
    public ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = Objects.requireNonNull(socket); // common for client and server
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public Socket getSocket() {
        return socket;
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
    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}

