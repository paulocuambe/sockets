package threaded.single;

import commons.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Constant.IP, Constant.PORT);

        String product = "b";

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(product.getBytes());

        byte[] response = new byte[100];
        inputStream.read(response);

        String strResponse = new String(response).trim();
        System.out.printf("Returned response is - %s", strResponse);
        socket.close();
    }
}
