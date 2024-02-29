import utils.Utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JsonServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12500);
            System.out.println(Utils.CYANMESSAGE + "Servidor esperando conexiones...");
            System.out.println(Utils.RESET);
            while (true) {
                Thread thread = new Thread(() -> {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());
                        System.out.println("Dirección: " + clientSocket.getLocalAddress());
                        System.out.println("Puerto: " + clientSocket.getPort());

                        InputStream inputStream = clientSocket.getInputStream();
                        DataInputStream reader = new DataInputStream(inputStream);

                        String jsonString = reader.readUTF();

                        System.out.println("Mensaje JSON recibido: " + Utils.GREENMESSAGE + jsonString);
                        System.out.println(Utils.RESET);

                        String response = Utils.PURPLEMESSAGE + "Mensaje recibido en el servidor " + Utils.RESET;
                        clientSocket.getOutputStream().write(response.getBytes());

                    } catch (Exception e) {
                        System.out.println(Utils.REDMESSAGE + "Error: " + e.getMessage());
                        e.printStackTrace();
                        System.out.println(Utils.RESET);
                    }
                });
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(Utils.REDMESSAGE + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }
}
