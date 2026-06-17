package src.mediator;
import java.util.ArrayList;
import java.util.List;
import src.User;



public class MediadorImplement implements Mediator {

    private List<User> users;



    public MediadorImplement(){
        this.users=new ArrayList<>();

    }
    @Override
    public void addUser(User user) {
       if (!this.users.contains(user)){
           this.users.add(user);
       }
        
    }

    @Override
    public void sendmessage(User user, String message) {

        for (User u: this.users){
             if (u!=user){
                u.receive("From : "+ user.getName() + ":" + message);
                

             }

        }
        
    }
    
    
}
