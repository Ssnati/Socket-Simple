import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class JsonClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.4.20.21", 12500);

            //JsonMessage jsonMessage = new JsonMessage("Juan", 25, "EjemploCity");
            CarrosJson jsonMessage = new CarrosJson("mazda", 2793, "rx-7", 1000);

            Gson gson = new Gson();
            String jsonString = gson.toJson(jsonMessage);

            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(jsonString);
            writer.write("\n"); // Agregar nueva línea para indicar el final del mensaje
            writer.flush();

            System.out.println("Mensaje JSON enviado al servidor.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            
            socket.close();
        } catch (IOException e) {
            //Colocar color rojo
            System.out.println("\u001B[31m" + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("\u001B[0m");
        }
    }
}
