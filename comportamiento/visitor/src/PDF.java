public class PDF implements Element {

    private String nombre;

    public PDF(String nombre) {
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