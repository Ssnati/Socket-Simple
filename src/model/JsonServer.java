package model;

import utils.Utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class JsonServer {
    public void startServer() {
        try {
            InetAddress localMachine = InetAddress.getLocalHost();
            ServerSocket serverSocket = new ServerSocket(12500);
            System.out.println(Utils.GREEN + "IP: " + localMachine.getHostAddress());
            System.out.println(Utils.GREEN + "PUERTO: " + serverSocket.getLocalPort());
            System.out.println(Utils.CYAN + "Servidor esperando conexiones...");
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

                        System.out.println("Mensaje JSON recibido: " + Utils.GREEN + jsonString);
                        System.out.println(Utils.RESET);

                        String response = Utils.PURPLE + "Mensaje recibido en el servidor " + Utils.RESET;
                        clientSocket.getOutputStream().write(response.getBytes());

                    } catch (Exception e) {
                        System.out.println(Utils.RED + "Error: " + e.getMessage());
                        e.printStackTrace();
                        System.out.println(Utils.RESET);
                    }
                });
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(Utils.RED + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }
}
