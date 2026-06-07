public class ImagenProxy implements Imagen {
    
    private String nombreArchivo;
    private ImagenReal imagenReal;
    
    public ImagenProxy(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    @Override
    public void mostrar() {
        if (imagenReal == null) {
            imagenReal = new ImagenReal(nombreArchivo);
        }
        imagenReal.mostrar();
    }
    
}
