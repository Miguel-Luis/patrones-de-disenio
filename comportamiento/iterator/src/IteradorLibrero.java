public class IteradorLibrero implements Iterador{
    private Librero librero;
    private int estadoIteracion; //Guarda indce acutual

    public IteradorLibrero(Librero librero){
        this.librero = librero;
        this.estadoIteracion = 0;
    }

    @Override
    public boolean hasSigue(){
        return estadoIteracion < librero.obtenerLibros().size();
    }

    @Override
    public Libro getSigue(){
        if(hasSigue()){
            Libro libroActual = librero.obtenerLibros().get(estadoIteracion);
            estadoIteracion++;
            return libroActual;

        }
        return null;

        

    }
}
