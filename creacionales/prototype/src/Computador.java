

public class Computador implements Prototype {

    private String tipo;
    private String procesador;
    private int ram;
    private String almacenamiento;
    private String tarjetaGrafica;

    public Computador(String tipo, String procesador, int ram,
                      String almacenamiento, String tarjetaGrafica) {
        this.tipo = tipo;
        this.procesador = procesador;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    @Override
    public Prototype clone() {
        return new Computador(
                tipo,
                procesador,
                ram,
                almacenamiento,
                tarjetaGrafica
        );
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    @Override
    public String toString() {
        return "\nTipo: " + tipo +
                "\nProcesador: " + procesador +
                "\nRAM: " + ram + " GB" +
                "\nAlmacenamiento: " + almacenamiento +
                "\nTarjeta gráfica: " + tarjetaGrafica;
    }
}