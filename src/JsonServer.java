import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JsonServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12500);
            System.out.println("\u001B[32m" + "Servidor esperando conexiones...");
            System.out.println("\u001B[0m");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());
                System.out.println("Dirección: " + clientSocket.getLocalAddress());
                System.out.println("Puerto: " + clientSocket.getPort());

                InputStream inputStream = clientSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead != -1) {
                    String jsonString = new String(buffer, 0, bytesRead);
                    System.out.println("Mensaje JSON recibido: " + jsonString);
                }

                String response = "\u001B[32m" + "Mensaje recibido" + "\u001B[0m";
                clientSocket.getOutputStream().write(response.getBytes());

                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("\u001B[0m");
        }
    }
}
