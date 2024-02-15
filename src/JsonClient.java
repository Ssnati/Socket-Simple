import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class JsonClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12500);

            JsonMessage jsonMessage = new JsonMessage("Juan", 25, "EjemploCity");

            Gson gson = new Gson();
            String jsonString = gson.toJson(jsonMessage);

            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(jsonString);
            writer.write("\n"); // Agregar nueva línea para indicar el final del mensaje
            writer.flush();

            System.out.println("Mensaje JSON enviado al servidor.");

            socket.close();
        } catch (IOException e) {
            //Colocar color rojo
            System.out.println("\u001B[31m" + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("\u001B[0m");
        }
    }
}
