package pojo;

public class CarrosJson {
    private String marca;
    private int placa;
    private String modelo;
    private int cilindraje;

    public CarrosJson(String marca, int placa, String modelo, int cilindraje) {
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return "CarrosJson{" +
                "marca='" + marca + '\'' +
                ", placa=" + placa +
                ", modelo='" + modelo + '\'' +
                ", cilindraje=" + cilindraje +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}