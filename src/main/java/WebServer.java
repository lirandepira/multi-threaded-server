import java.net.ServerSocket;

public class WebServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Port listening");

        for (int i = 0; i < 10; i++) {

            ServerThread serverThread = new ServerThread(serverSocket);
            Thread singleThread = new Thread(serverThread);
            singleThread.start();
        }

        while (true) {
            Thread.sleep(10 * 1000);
        }

    }
}