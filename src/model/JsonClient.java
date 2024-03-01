package model;

import com.google.gson.Gson;
import pojo.Person;
import utils.Utils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class JsonClient {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void startClient(String ip, int port) {
        try {
            List<Person> personList = new PersonManager().getPersonList();
            Socket socket = new Socket(ip, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                sendMessage(personList);
                Utils.sleepThread(30);
            }
        } catch (IOException e) {
            System.out.println(Utils.RED + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }

    private void sendMessage(List<Person> jsonList) throws IOException {
        Gson gson = new Gson();
        Person persona = jsonList.get((int) (Math.random() * 10));
        dataOutputStream.writeUTF(gson.toJson(persona));
        System.out.println(Utils.BLUE + "Mensaje enviado : " + persona.getName() + " " + persona.getLastName() + " " + persona.getDateBirth() + " " + persona.getBornIn() + " " + persona.getRandomNumber() + " " + InetAddress.getLocalHost().getHostName()+ Utils.RESET);
    }

}


