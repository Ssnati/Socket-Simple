package model;

import com.google.gson.Gson;
import pojo.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

public class PersonManager {
    private List<Person> people;

    public PersonManager() {
        people = new LinkedList<>();
        try {
            loadData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadData() throws IOException {
        String data = getData();
        Gson gson = new Gson();
        Person[] personFromJson = gson.fromJson(data, Person[].class);
        people = List.of(personFromJson);
        changePcName();
    }

    private void changePcName() throws UnknownHostException {
        for (Person person : people) {
            person.setNameClient(InetAddress.getLocalHost().getHostName());
            person.setRandomNumber((int) (Math.random() * 100));
        }
    }

    public List<Person> getPersonList() {
        return people;
    }

    private String getData() {
        return "[\n" +
                "    {\n" +
                "        \"name\": \"Juan\",\n" +
                "        \"lastName\": \"Perez\",\n" +
                "        \"dateBirth\": \"1990-05-15\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"001\",\n" +
                "            \"name\": \"Bogotá\"\n" +
                "        },\n" +
                "        \"randomNumber\": 123,\n" +
                "        \"nameClient\": \"Client1-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Maria\",\n" +
                "        \"lastName\": \"Gomez\",\n" +
                "        \"dateBirth\": \"1985-09-22\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"002\",\n" +
                "            \"name\": \"Medellín\"\n" +
                "        },\n" +
                "        \"randomNumber\": 456,\n" +
                "        \"nameClient\": \"Client2-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Carlos\",\n" +
                "        \"lastName\": \"Rodriguez\",\n" +
                "        \"dateBirth\": \"1998-12-10\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"003\",\n" +
                "            \"name\": \"Cali\"\n" +
                "        },\n" +
                "        \"randomNumber\": 789,\n" +
                "        \"nameClient\": \"Client3-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Laura\",\n" +
                "        \"lastName\": \"Martinez\",\n" +
                "        \"dateBirth\": \"1982-04-05\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"004\",\n" +
                "            \"name\": \"Cartagena\"\n" +
                "        },\n" +
                "        \"randomNumber\": 234,\n" +
                "        \"nameClient\": \"Client4-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Pedro\",\n" +
                "        \"lastName\": \"Lopez\",\n" +
                "        \"dateBirth\": \"1995-08-18\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"005\",\n" +
                "            \"name\": \"Santa Marta\"\n" +
                "        },\n" +
                "        \"randomNumber\": 567,\n" +
                "        \"nameClient\": \"Client5-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Ana\",\n" +
                "        \"lastName\": \"Ramirez\",\n" +
                "        \"dateBirth\": \"1989-11-30\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"006\",\n" +
                "            \"name\": \"Barranquilla\"\n" +
                "        },\n" +
                "        \"randomNumber\": 890,\n" +
                "        \"nameClient\": \"Client6-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Jorge\",\n" +
                "        \"lastName\": \"Diaz\",\n" +
                "        \"dateBirth\": \"1993-03-12\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"007\",\n" +
                "            \"name\": \"Pereira\"\n" +
                "        },\n" +
                "        \"randomNumber\": 345,\n" +
                "        \"nameClient\": \"Client7-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Luisa\",\n" +
                "        \"lastName\": \"Hernandez\",\n" +
                "        \"dateBirth\": \"1987-06-25\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"008\",\n" +
                "            \"name\": \"Manizales\"\n" +
                "        },\n" +
                "        \"randomNumber\": 678,\n" +
                "        \"nameClient\": \"Client8-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Ricardo\",\n" +
                "        \"lastName\": \"Vargas\",\n" +
                "        \"dateBirth\": \"1996-09-08\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"009\",\n" +
                "            \"name\": \"Ibagué\"\n" +
                "        },\n" +
                "        \"randomNumber\": 123,\n" +
                "        \"nameClient\": \"Client9-PC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Sofia\",\n" +
                "        \"lastName\": \"Gutierrez\",\n" +
                "        \"dateBirth\": \"1984-02-14\",\n" +
                "        \"bornIn\": {\n" +
                "            \"daneCode\": \"010\",\n" +
                "            \"name\": \"Armenia\"\n" +
                "        },\n" +
                "        \"randomNumber\": 456,\n" +
                "        \"nameClient\": \"Client10-PC\"\n" +
                "    }\n" +
                "]\n";
    }
}
