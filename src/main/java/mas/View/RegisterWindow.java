package mas.View;

import mas.Main;
import mas.Models.Member;
import mas.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
        submitButton.addActionListener(actionEvent -> registerNewUser());
        cancelButton.addActionListener(actionEvent -> Utils.closeWindow(this));
    }


    void registerNewUser(){
        Member.addNewUser(this.nameField.getText(), this.surnameField.getText(), this.emailField.getText(), Arrays.toString(this.passwordField1.getPassword()), LocalDate.of(1998, 3, 5));
        JOptionPane.showMessageDialog(this, "New user created", "New user", JOptionPane.INFORMATION_MESSAGE);
        Utils.closeWindow(this);
    }

    @Override
    public void run() {

    }
}
