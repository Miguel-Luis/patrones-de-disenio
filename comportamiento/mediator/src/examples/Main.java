package src.examples;
import src.UserImpl;
import src.UserLayer;
import src.controller.UserController;
import src.mediator.MediadorImplement;
import src.mediator.Mediator;

public class Main {
    public static void main(String[] args) {
        Mediator med = new MediadorImplement();

        // Change 'User' to 'UserImpl' so the Controller accepts them!
        UserImpl user1 = new UserImpl("Lorena", "312231432", med, 0);
        UserLayer view1 = new UserLayer();
        UserController controller1 = new UserController(user1, view1);
        med.addUser(user1);

        UserImpl user2 = new UserImpl("Carlos", "310445678", med, 1);
        UserLayer view2 = new UserLayer();
        UserController controller2 = new UserController(user2, view2);
        med.addUser(user2);

        UserImpl user3 = new UserImpl("Daniel", "3235413069", med, 2);
        UserLayer view3 = new UserLayer();
        UserController controller3 = new UserController(user3, view3);
        med.addUser(user3);
    }
}