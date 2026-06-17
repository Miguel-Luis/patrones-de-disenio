package facade.src.subsystems;

public class LucesTenues {
    public void encender() {
        System.out.println("💡 Luces de la sala encendidas.");
    }
    public void atenuar(int porcentaje) {
        System.out.println(" Luces al " + porcentaje + "%. Ambiente de cine listo.");
    }
    public void apagar() {
        System.out.println("💡 Luces de la sala apagadas completamente.");
    }
}