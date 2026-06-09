import java.util.ArrayList;
import java.util.List;


public class Librero implements ColeccionIterable {

    private List<Libro> libros;

    public Librero(){
        this.libros = new ArrayList<>();
    }
    public void agregarLibro(Libro libro){
        this.libros.add(libro);
    }
    public List<Libro>obtenerLibros(){
        return this.libros;
    }

    @Override
    public Iterador crearIterador(){
        return new IteradorLibrero(this);
    }
    
}
