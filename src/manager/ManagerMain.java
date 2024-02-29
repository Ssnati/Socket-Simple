package manager;

import model.JsonClient;
import model.JsonServer;
import utils.Utils;

public class ManagerMain {
    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "client" -> startAsClient();
                case "server" -> startAsServer();
                default -> printErrorMessage("Parámetro invalido");
            }
        } else {
            printErrorMessage("El programa requiere parámetros");
            parametersMessage();
        }
    }

    private static void parametersMessage() {
        System.out.println(Utils.BLUE + "Parámetros posibles: \n" +
                " client        Ejecuta el programa como cliente, el cliente se usa para enviar mensajes\n" +
                " server        Ejecuta el programa como servidor, el servidor se encarga de recibir mensajes" +
                Utils.RESET);
    }

    private static void startAsServer() {
        new JsonServer().startServer();
    }

    private static void startAsClient() {
        new JsonClient().startClient();
    }

    private static void printErrorMessage(String message) {
        System.out.println(Utils.RED + "Error: " + message);
    }
}
