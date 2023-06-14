package mas.View;

import javax.swing.*;

public class RegisterWindow extends JFrame implements Runnable{
    private JPanel panel;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JTextField textField3;

    public RegisterWindow(){
        this.add(panel);
        this.setVisible(true);
        this.setSize(350,200);
    }

    @Override
    public void run() {

    }
}
