package facade.src.subsystems;

public class Proyector {
    public void encender() {
        System.out.println("📽️ Proyector encendido.");
    }
    public void setInputHDMI() {
        System.out.println("📽️ Configurando entrada del proyector en modo 'HDMI 1 / Blu-Ray'.");
    }
    public void modoPantallaAncha() {
        System.out.println("📽️ Relación de aspecto del proyector configurada en 16:9.");
    }
    public void apagar() {
        System.out.println("📽️ Apagando proyector.");
    }
}
