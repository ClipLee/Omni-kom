package mas.View;

import mas.Main;
import mas.Models.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterWindow extends JFrame implements Runnable{
    private JPanel panel;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextField nameField;
    private JPasswordField passwordField1;
    private JTextField surnameField;
    private JTextField emailField;

    public RegisterWindow(){
        this.add(panel);
        this.setVisible(true);
        this.setSize(350,200);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registerNewUser();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                closeWindow();
            }
        });
    }


    void registerNewUser(){
        Member.addNewUser(this.nameField.getText(), this.surnameField.getText(), this.emailField.getText(), Arrays.toString(this.passwordField1.getPassword()));
        JOptionPane.showMessageDialog(this, "New user created", "New user", JOptionPane.INFORMATION_MESSAGE);
        closeWindow();
    }


    void closeWindow(){
        this.dispose();
    }

    @Override
    public void run() {

    }
}
