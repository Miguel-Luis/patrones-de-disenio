public class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV encendida");
    }

    @Override
    public void turnOff() {
        System.out.println("TV apagada");
    }

    @Deprecated
    public void setVolume(int volume) {
        System.out.println("Volumen de TV ajustado a: " + volume);
    }
}