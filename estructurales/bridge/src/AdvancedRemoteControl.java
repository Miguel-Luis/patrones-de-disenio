
public class AdvancedRemoteControl extends RemoteControl {



    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
    
}
