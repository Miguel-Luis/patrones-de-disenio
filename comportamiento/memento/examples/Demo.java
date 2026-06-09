public class Demo {
    public static void main(String[] args) {
        Documento editor = new Documento();
        Historial historial = new Historial();

        editor.escribir("Versión 1: Informe inicial");
        historial.agregar(editor.guardar());

        editor.escribir("Versión 2: Informe con conclusiones");
        historial.agregar(editor.guardar());

        editor.escribir("Versión 3: Informe final con anexos");

        System.out.println("\n--- Restaurando versiones anteriores ---");
        editor.restaurar(historial.obtener(0));
        editor.restaurar(historial.obtener(1));
    }
}
