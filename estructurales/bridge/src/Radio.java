public class Radio implements Device {

    @Override
    public void turnOn() {
        System.out.println("Radio encendida");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio apagada");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Volumen de Radio ajustado a: " + volume);
    }
}