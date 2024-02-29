package manager;

import model.JsonClient;
import model.JsonServer;
import utils.Utils;

public class ManagerMain {
    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "client" -> startAsClient(args);
                case "server" -> startAsServer(args);
                default -> printErrorMessage("Parámetro invalido");
            }
        } else {
            printErrorMessage("El programa requiere parámetros");
            parametersMessage();
        }
    }

    private static void parametersMessage() {
        System.out.println(Utils.BLUE + "Parámetros posibles: \n" +
                "(Primer parámetro obligatorio)\n" +
                " client        Ejecuta el programa como cliente, el cliente se usa para enviar mensajes\n" +
                " server        Ejecuta el programa como servidor, el servidor se encarga de recibir mensajes\n" +
                "\n" +
                "--Parámetros Opcionales\n" +
                "(Segundo parámetro)\n" +
                " ip            ip a la que se desea conectar (Ej:127.0.0.1)\n" +
                "           -server no necesita ip\n" +
                "\n" +
                "(Tercer parámetro)\n" +
                " puerto        puerto al que se desea conectar (Ej:8080)\n" +
                Utils.RESET);
    }

    private static void startAsServer(String[] args) {
        if (args.length > 1 && (args[1] != null)) {
            new JsonServer().startServer(Integer.parseInt(args[1]));
        } else {
            new JsonServer().startServer(12500);
        }
    }

    private static void startAsClient(String[] args) {
        if (args.length > 1) {
            if ((args[1] != null) && (args[2] != null)) {
                new JsonClient().startClient(args[1], Integer.parseInt(args[2]));
            }
        } else {
            new JsonClient().startClient("localhost", 12500);
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println(Utils.RED + "Error: " + message);
    }
}
