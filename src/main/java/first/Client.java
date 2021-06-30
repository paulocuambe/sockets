package first;

import commons.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Constant.IP, Constant.PORT);

        System.out.println("Conected to the server ...");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("Hello from client".getBytes());

        byte[] response = new byte[1024];
        inputStream.read(response);

        System.out.println("Received from server " + Arrays.toString(response));
        System.out.println("Received from server - " + new String(response) + " - end");
        System.out.println("Received from server - " + new String(response).trim() + " - end");

        socket.close();
    }
}
