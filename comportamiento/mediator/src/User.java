package src;
import javax.print.attribute.standard.Media;

import src.mediator.Mediator;

public abstract class User {
    int id;
    String name;
    String number;
    Mediator mediator;
  


    public User(String name,String number,Mediator mediator,int id){
        this.name=name;
        this.number=number;
        this.mediator=mediator;
        this.id=id;

    }


    public  abstract void send(String message);
    public  abstract void receive(String message);

  


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public Mediator getMediator() {
        return mediator;
    }


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    
} 
