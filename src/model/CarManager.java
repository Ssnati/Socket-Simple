package model;

import com.google.gson.Gson;
import pojo.CarrosJson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CarManager {
    private List<CarrosJson> carList;

    public CarManager() {
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
        BufferedReader reader = new BufferedReader(new FileReader("data/Cars.json"));
        String data = readAllData(reader);
        Gson gson = new Gson();
        CarrosJson[] carFromJson = gson.fromJson(data, CarrosJson[].class);
        carList = List.of(carFromJson);
    }

    private String readAllData(BufferedReader reader) throws IOException {
        StringBuilder allData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            allData.append(line);
        }
        return allData.toString();
    }

    public List<CarrosJson> getCarList() {
        return carList;
    }

}
