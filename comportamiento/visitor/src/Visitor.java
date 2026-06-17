public interface Visitor {

    void visit(PDF pdf);

    void visit(Word word);
}