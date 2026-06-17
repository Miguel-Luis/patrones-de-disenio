package src.mediator;
import src.User;
public interface Mediator {

    public void sendmessage(User user,String message);

    public void addUser(User user);
    
}
