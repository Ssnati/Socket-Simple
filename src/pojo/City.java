package pojo;

public class City {
    private String daneCode;
    private String name;

    public City(String daneCode, String name) {
        this.daneCode = daneCode;
        this.name = name;
    }

    public String getDaneCode() {
        return daneCode;
    }

    public void setDaneCode(String daneCode) {
        this.daneCode = daneCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
