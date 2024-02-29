package pojo;

public class JsonMessage {
    private String nombre;
    private int edad;
    private String ciudad;

    public JsonMessage(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "JsonMessage{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
