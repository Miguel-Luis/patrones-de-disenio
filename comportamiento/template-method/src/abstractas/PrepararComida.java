package abstractas;

public abstract class PrepararComida {
    public void prepararPlato(){
        prepararIngredientes();
        cocinar();
        servir();
        AgregarExtras();
    }

    protected abstract void prepararIngredientes();
    protected abstract void cocinar();
    protected abstract void servir();

    protected void AgregarExtras(){
        System.out.println("Agregando extras...");
    }
}
