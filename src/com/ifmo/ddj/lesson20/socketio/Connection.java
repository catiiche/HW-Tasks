package com.ifmo.ddj.lesson20.socketio;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

public class Connection implements AutoCloseable {
    // объект типа Socket позволит клиенту установить соединение с сервером, а серверу принять клиента
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private static final long serialVersionID = 1L;

    public Connection(Socket socket) throws IOException {
        this.socket = socket; // общий для клиента и сервера
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // метод преобразует message в последовательность байт и потом передаст
        // эту последовательность в сокет OutputStream - > данные пойдут по соединению
        output.flush(); //особенность socket.getOutputStream() принудительно отправляем байты
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    @Override
    // будет вызван автоматически после завершения конструкции try блока  если объект Connection был создан в () try
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = Connection.class.getClassLoader()
                .getResourceAsStream("ClientServer.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return properties;
    }
}

//  интерфейс AutoCloseable + close() позволит создать объекты в try-with-source блоке

// client ====== server
// c соединением работаем благодаря сокетам
// ObjectOutputStream и ObjectInputStream раньше у нас работали с файлами, теперь вместо файла - соединение

