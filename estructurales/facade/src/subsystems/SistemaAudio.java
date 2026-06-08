package facade.src.subsystems;

public class SistemaAudio {
    public void encender() {
        System.out.println("🔊 Sistema de audio sonido Surround encendido.");
    }
    public void setVolumen(int nivel) {
        System.out.println("🔊 Volumen del audio ajustado a nivel: " + nivel);
    }
    public void apagar() {
        System.out.println("🔊 Sistema de audio apagado.");
    }
}
