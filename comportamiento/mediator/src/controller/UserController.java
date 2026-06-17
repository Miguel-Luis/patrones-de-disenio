package src.controller;

import src.MessageListener;
import src.UserImpl;
import src.UserLayer;

public class UserController implements MessageListener {
    private UserLayer view;
    private UserImpl model;

    public UserController(UserImpl model, UserLayer view){
        this.model = model;
        this.view = view;
        this.view.SetGUI(model);

        model.setMessageListener(this);
        this.view.getSendButton().addActionListener(e -> handleSend());
    }

    private void handleSend(){
        String message = view.getInputfield().getText().trim();
        if (!message.isEmpty()){
            // The CONTROLLER updates the view for our own sent messages!
            view.displayMessage("Me : " + message + "\n");
            model.send(message);
            view.getInputfield().setText("");
        }
    }

    @Override
    public void onMessageReceived(String message) {
        view.displayMessage(message + "\n");
    }
}