package core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private InetAddress inetAddress;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public void boot() throws IOException, ClassNotFoundException {
        inetAddress = InetAddress.getLocalHost();
        serverSocket = new ServerSocket(5555);

        listen();
    }

    private void listen() throws IOException, ClassNotFoundException {
        while (true){
            openStreams();
            send(read());
            closeStreams();
        }
    }

    private void closeStreams() throws IOException {
        objectOutputStream.close();
        objectInputStream.close();
        socket.close();
    }

    private void openStreams() throws IOException {
        socket = serverSocket.accept();
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    private void send(String msg) throws IOException {
        objectOutputStream.writeObject(msg);
    }

    private String read() throws IOException, ClassNotFoundException {
        return (String) objectInputStream.readObject();
    }

}
