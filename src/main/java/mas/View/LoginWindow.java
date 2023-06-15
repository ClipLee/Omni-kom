package mas.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements Runnable{
    private JPanel panel;
    private JTextField userNameField;
    private JButton loginButton;
    private JButton cancelButton;
    private JPasswordField passwordField1;

    public LoginWindow(){
        this.add(panel);
        this.setVisible(true);
        this.setSize(350,200);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                closeWindow();
            }
        });
    }

    void login(){
        JOptionPane.showMessageDialog(this, "Logged in", "User logged in", JOptionPane.INFORMATION_MESSAGE);
        closeWindow();
    }

    void closeWindow(){
        this.dispose();
    }

    @Override
    public void run() {

    }
}
