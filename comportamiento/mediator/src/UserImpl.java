package src;
import javax.swing.*;
import javax.swing.border.Border;

import src.mediator.Mediator;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class UserImpl extends User {

    private UserLayer userlayer;
      private MessageListener listener;


    public UserImpl(String name,String number,Mediator mediator,int id){
        super(name,number,mediator,id);
     

        
        

    }

      public   void setMessageListener(MessageListener listener) {
        this.listener = listener;
    }

    
    @Override
    public void receive(String message) {
          
        if (listener!= null){
            listener.onMessageReceived(message);
        }

        
    }


    @Override
    public void send(String message) {
          
           mediator.sendmessage(this, message); 

    }






    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        // The code you asked about!
        UserImpl user = (UserImpl) o;
        return this.id == user.id;
    }






@Override

public int hashCode() {

return Objects.hash(id);

}




    
}
