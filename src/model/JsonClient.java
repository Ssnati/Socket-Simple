package model;

import com.google.gson.Gson;
import pojo.Person;
import utils.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class JsonClient {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void startClient(String ip, int port) {
        try {
            List<Person> people = new PersonManager().getPersonList();
            Socket socket = new Socket(ip, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                sendMessage(people);
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
        Person person = jsonList.get((int) (Math.random() * jsonList.size()));
        dataOutputStream.writeUTF(gson.toJson(person));
        System.out.println(Utils.BLUE + "Mensaje enviado : " + person.getName() + " " + person.getLastName() + Utils.RESET);
    }

}


