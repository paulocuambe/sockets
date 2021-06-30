package threaded.single;

import commons.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constant.PORT);
        System.out.printf("Listening on port %d%n", Constant.PORT);

        QuoteService quoteService = new QuoteService();

        while (true) {
            System.out.println("\nWaiting for the client...");
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStreamStream = socket.getOutputStream();

            byte[] request = new byte[100];
            inputStream.read(request);

            String product = new String(request).trim();
            System.out.printf("Received product name - %s%n", product);

            String price = quoteService.getQuote(product);
            if (price == null) {
                price = "Invalid product";
            }

            outputStreamStream.write(price.getBytes());

            socket.close();
            System.out.println("Response sent back...");
        }
    }
}
