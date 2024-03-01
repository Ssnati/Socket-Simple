package model;

import com.google.gson.Gson;
import pojo.CarrosJson;
import utils.Utils;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class JsonClient {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void startClient(String ip, int port) {
        try {
            List<CarrosJson> carList = new CarManager().getCarList();
            Socket socket = new Socket(ip, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                sendMessage(carList);
                Utils.sleepThread(2);
            }
        } catch (IOException e) {
            System.out.println(Utils.RED + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }

    private void sendMessage(List<CarrosJson> jsonList) throws IOException {
        Gson gson = new Gson();
        dataOutputStream.writeUTF(gson.toJson(jsonList.get((int) (Math.random() * 10))));
    }

    private void handleServerResponse() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
        System.out.println(bufferedReader.readLine());
    }
}


