package facade.src;
import facade.src.subsystems.*;

public class HomeTheaterFacade {
    // Atributos privados de los subsistemas
    private LucesTenues luces;
    private MaquinaPalomitas maquinaPalomitas;
    private Proyector proyector;
    private SistemaAudio audio;
    private ReproductorVideo reproductor;

    // Constructor sin parámetros: la fachada crea sus propias dependencias
    public HomeTheaterFacade() {
        this.luces = new LucesTenues();
        this.maquinaPalomitas = new MaquinaPalomitas();
        this.proyector = new Proyector();
        this.audio = new SistemaAudio();
        this.reproductor = new ReproductorVideo();
    }

    public void comenzarPelicula(String pelicula) {
        System.out.println("\n--- [Fachada] Preparando modo cine... ---");
        maquinaPalomitas.encender();
        maquinaPalomitas.cocinar();
        luces.atenuar(10);
        proyector.encender();
        audio.encender();
        audio.setVolumen(25);
        reproductor.encender();
        reproductor.reproducir(pelicula);
    }

    public void terminarPelicula() {
        System.out.println("\n--- [Fachada] Apagando sistema... ---");
        maquinaPalomitas.apagar();
        luces.encender();
        proyector.apagar();
        audio.apagar();
        reproductor.apagar();
    }
}