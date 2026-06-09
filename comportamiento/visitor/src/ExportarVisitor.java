public class ExportarVisitor implements Visitor {

    @Override
    public void visit(PDF pdf) {
        System.out.println("Exportando PDF: " + pdf.getNombre());
    }

    @Override
    public void visit(Word word) {
        System.out.println("Exportando Word: " + word.getNombre());
    }
}