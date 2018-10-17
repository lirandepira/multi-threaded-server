import java.net.ServerSocket;

public class WebServer {

    public static void main(String[] args) throws Exception {

        // Open port for connection
        ServerSocket serverSocket = new ServerSocket(2134);
        System.out.println("Port listening");

        // Manage multiple threads
        for (int i = 0; i < 10; i++) {

            ServerThread serverThread = new ServerThread(serverSocket);
            Thread singleThread = new Thread(serverThread);
            singleThread.start();
        }

        // Simulate a longer process
        while (true) {
            Thread.sleep(10 * 1000);
        }

    }
}