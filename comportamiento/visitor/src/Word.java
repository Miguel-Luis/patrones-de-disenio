public class Word implements Element {

    private String nombre;

    public Word(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}