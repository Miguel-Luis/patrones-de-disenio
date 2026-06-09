//Receptor: la lámpara (lógica)
public class Lampara {
    private boolean encendida = false;

    public boolean encendida() {
        return encendida;
    }

    public void encender() {
        encendida = true;
        System.out.println("Lámpara encendida");
    }
    
    public void apagar() {
        encendida = false;
        System.out.println("Lámpara apagada");
    }
    
    
}
