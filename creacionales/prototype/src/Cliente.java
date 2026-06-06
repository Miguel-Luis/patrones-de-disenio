public class Cliente {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarPedido(Computador computador) {
        System.out.println("\nCliente: " + nombre);
        System.out.println(computador);
    }
}