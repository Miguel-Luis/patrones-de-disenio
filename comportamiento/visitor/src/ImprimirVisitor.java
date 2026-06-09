public class ImprimirVisitor implements Visitor {

    @Override
    public void visit(PDF pdf) {
        System.out.println("Imprimiendo PDF: " + pdf.getNombre());
    }

    @Override
    public void visit(Word word) {
        System.out.println("Imprimiendo Word: " + word.getNombre());
    }
}