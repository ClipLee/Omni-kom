package mas.View;

import javax.swing.*;

public class LoginWindow extends JFrame implements Runnable{
    private JPanel panel;
    private JTextField textField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JPasswordField passwordField1;

    public LoginWindow(){
        this.add(panel);
        this.setVisible(true);
        this.setSize(350,200);
    }

    @Override
    public void run() {

    }
}
