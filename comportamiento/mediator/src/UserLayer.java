package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLayer {
    private JFrame window;
    private JTextArea chatArea;
    private JTextField  inputfield;
    private JButton   sendButton;


    public UserLayer(){
  
     

    }
    

      public void SetGUI (User user){

        window= new JFrame(user.name + " (" + user.number + ") " );
        window.setSize(350, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Offset each window slightly based on ID so they don't stack perfectly on top of each other
        window.setLocation(100 + (user.id*150), 100 + (user.id *50));
        window.setLayout(new BorderLayout());
        


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane=new JScrollPane(chatArea);
        window.add(scrollPane,BorderLayout.CENTER);


        JPanel bottomPanel=new JPanel(new BorderLayout());
        inputfield=new JTextField();
        sendButton= new JButton("Send");

        bottomPanel.add(inputfield,BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        window.add(bottomPanel, BorderLayout.SOUTH);


    
        inputfield.addActionListener(e->sendButton.doClick());

        window.setVisible(true);

    }

    public  void displayMessage(String message){

        chatArea.append(message);

    }


      public JFrame getWindow() {
          return window;
      }


      public void setWindow(JFrame window) {
          this.window = window;
      }


      public JTextArea getChatArea() {
          return chatArea;
      }


      public void setChatArea(JTextArea chatArea) {
          this.chatArea = chatArea;
      }


      public JTextField getInputfield() {
          return inputfield;
      }


      public void setInputfield(JTextField inputfield) {
          this.inputfield = inputfield;
      }


      public JButton getSendButton() {
          return sendButton;
      }


      public void setSendButton(JButton sendButton) {
          this.sendButton = sendButton;
      }
}
