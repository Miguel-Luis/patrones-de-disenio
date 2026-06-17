public class Demo {
   
    public static void main(String[] args) {
        Device tv = new TV();

        AdvancedRemoteControl remote = new AdvancedRemoteControl(tv);

            remote.turnOn();
            remote.setVolume(10);
            remote.turnOff();

        System.out.println();

        Device radio = new Radio();
        AdvancedRemoteControl remote2 = new AdvancedRemoteControl(radio);

            remote2.turnOn();
            remote2.setVolume(5);
            remote2.turnOff();
    }
}