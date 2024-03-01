package model;

import com.google.gson.Gson;
import pojo.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PersonManager {
    private List<Person> carList;

    public PersonManager() {
        carList = new LinkedList<>();
        try {
            loadData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/Perosn.json"));
        String data = readAllData(reader);
        Gson gson = new Gson();
        Person[] personFromJson = gson.fromJson(data, Person[].class);
        carList = List.of(personFromJson);
    }

    private String readAllData(BufferedReader reader) throws IOException {
        StringBuilder allData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            allData.append(line);
        }
        return allData.toString();
    }

    public List<Person> getPersonList() {
        return carList;
    }

}
