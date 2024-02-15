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
        return "JsonMessage{" +
                "marca='" + marca + '\'' +
                ", placa=" + placa +
                ", modelo='" + modelo + '\'' +
                ", cilindraje=" + cilindraje +
                '}';
    }
}