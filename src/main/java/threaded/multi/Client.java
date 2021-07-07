package threaded.multi;

import commons.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(Constant.IP, Constant.PORT);
        socket.setSoTimeout(2000);
        String product = "a";

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(product.getBytes());

        byte[] response = new byte[100];

        int i = 1;
        do {
            try {
                inputStream.read(response);
                break;
            } catch (SocketTimeoutException exception) {
                System.out.println(String.format("Erro - %d", i));
                i++;
            }
        } while (i <= 2);


        String strResponse = new String(response).trim();
        System.out.printf("\nReturned response is - %s", strResponse);
        socket.close();
    }
}
