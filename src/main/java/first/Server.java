package first;

import commons.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constant.PORT);

        System.out.println("Waiting for ping from the client...");
        Socket clientSocket = serverSocket.accept();

        System.out.println("first.Client connected...");
        InputStream inputStream = clientSocket.getInputStream(); // read from client
        OutputStream outputStream = clientSocket.getOutputStream(); // write to the client

        byte[] buffer = new byte[1024];
        inputStream.read(buffer);

        System.out.println("Received from client " + Arrays.toString(buffer));
        System.out.println("Received from client - " + new String(buffer) + " - end");
        System.out.println("Received from client - " + new String(buffer).trim() + " - end");

        outputStream.write("Hello from first.Server".getBytes());

        clientSocket.close();
        serverSocket.close();
    }
}
