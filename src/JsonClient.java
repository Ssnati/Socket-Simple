import com.google.gson.Gson;
import utils.Utils;

import java.io.*;
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
            writer.write("\n");
            writer.flush();

            System.out.println("Mensaje JSON enviado al servidor.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            
            socket.close();
        } catch (IOException e) {
            System.out.println(Utils.REDMESSAGE + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }
}
