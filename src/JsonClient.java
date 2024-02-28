import com.google.gson.Gson;
import utils.Utils;

import java.io.*;
import java.net.Socket;

public class JsonClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {

                try {
                    Socket socket = new Socket("localhost", 12500);

                    //JsonMessage jsonMessage = new JsonMessage("Juan", 25, "EjemploCity");
                    CarrosJson jsonMessage = new CarrosJson("mazda", 2793, "rx-7", 1000);

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(jsonMessage);

                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream);
                    writer.write(jsonString);
                    writer.write("\n");

                    System.out.println("Mensaje JSON enviado al servidor.");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println(bufferedReader.readLine());


                } catch (IOException e) {
                    System.out.println(Utils.REDMESSAGE + "Error: " + e.getMessage());
                    e.printStackTrace();
                    System.out.println(Utils.RESET);
                }
            });
            thread.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
