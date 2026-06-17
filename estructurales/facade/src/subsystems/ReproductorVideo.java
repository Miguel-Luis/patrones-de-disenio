package facade.src.subsystems;

public class ReproductorVideo {
    public void encender() {
        System.out.println("💿 Reproductor de video encendido.");
    }
    public void reproducir(String pelicula) {
        System.out.println("🎬 Reproduciendo la película: \"" + pelicula + "\". ¡Disfruta la función!");
    }
    public void detener() {
        System.out.println("💿 Película detenida.");
    }
    public void apagar() {
        System.out.println("💿 Reproductor de video apagado.");
    }
}
