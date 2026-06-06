public class Demo {

    public static void main(String[] args) {

        Cliente juan = new Cliente("Juan");
        Cliente maria = new Cliente("María");

        // 🔹 Crear el catálogo 
        CatalogoComputadores catalogo = new CatalogoComputadores();

        // Clonar prototipo Gamer desde el catálogo
        Computador pedidoJuan =
                (Computador) catalogo.getGamer().clone();

        pedidoJuan.setRam(32);

        // Clonar prototipo Oficina desde el catálogo
        Computador pedidoMaria =
                (Computador) catalogo.getOficina().clone();

        pedidoMaria.setAlmacenamiento("1TB SSD");

        System.out.println("=== PROTOTIPOS DISPONIBLES ===");

        System.out.println(catalogo.getGamer());
        System.out.println(catalogo.getOficina());
        System.out.println(catalogo.getDiseno());

        System.out.println("\n=== PEDIDOS GENERADOS POR CLONACIÓN ===");

        juan.mostrarPedido(pedidoJuan);
        maria.mostrarPedido(pedidoMaria);
    }
}