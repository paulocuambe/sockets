package threaded.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServiceThread extends Thread{

    private Socket socket;
    private QuoteService quoteService;

    public ServiceThread(Socket socket) {
        this.socket = socket;
        quoteService = new QuoteService();
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            System.out.println("Waiting for product information from the client.");

            byte[] request = new byte[100];
            inputStream.read(request);

            String product = new String(request).trim();
            String price = quoteService.getQuote(product);

            System.out.printf("Received product name - %s%n", product);

            if (price == null){
                price = "Invalid product";
            }

            outputStream.write(price.getBytes());
            System.out.println("Response sent...");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public QuoteService getQuoteService() {
        return quoteService;
    }

    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }
}
