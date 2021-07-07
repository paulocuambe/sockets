package threaded.multi;

import commons.Constant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(Constant.PORT);
        System.out.printf("Listening on port %d%n", Constant.PORT);

        while (true) {
            System.out.println("\nWaiting for the client...");
            Socket socket = serverSocket.accept();
            Thread.sleep(2001);

            System.out.println("Starting a thread wich will service the client");
            new ServiceThread(socket).start();
        }
    }
}
