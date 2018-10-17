import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

    ServerSocket serverSocket;

    public ServerThread(ServerSocket serverSocket){

        this.serverSocket= serverSocket;
    }

    @Override
    public void run() {
        while (true){
            try {

                // listen for a connection
                Socket socket = serverSocket.accept();
                System.out.println("Connection accepted");

                // Send data to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("\r\n");
                out.println("<p> Hello world </p>");
                out.flush();

                out.close();

                // This sleep is used after the thread limit is succeeded
                Thread.sleep(60*1000);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
