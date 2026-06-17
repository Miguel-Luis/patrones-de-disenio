
public class Demo {

    public static void main(String[] args) {

        PDF pdf = new PDF("Manual.pdf");
        Word word = new Word("Informe.docx");

        Visitor imprimir = new ImprimirVisitor();
        Visitor exportar = new ExportarVisitor();

        System.out.println("=== IMPRIMIR ===");
        pdf.accept(imprimir);
        word.accept(imprimir);

        System.out.println("\n=== EXPORTAR ===");
        pdf.accept(exportar);
        word.accept(exportar);
    }
}