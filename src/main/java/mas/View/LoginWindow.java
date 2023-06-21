package mas.View;

import mas.Main;
import mas.Models.Member;
import mas.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

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
        loginButton.addActionListener(actionEvent -> login());
        cancelButton.addActionListener(actionEvent -> Utils.closeWindow(this));
    }

    void login(){
        try{
            Member m = selectMember();
            SwingUtilities.invokeLater(new MainWindow(m));
            JOptionPane.showMessageDialog(this, "Logged in", "User logged in", JOptionPane.INFORMATION_MESSAGE);
        }catch (NoSuchElementException n){
            JOptionPane.showMessageDialog(this, "There is no such member", "No such member", JOptionPane.ERROR_MESSAGE);
        }

        Utils.closeWindow(this);
    }

    private Member selectMember(){
        for (Member m: Main.userList) if (m.getName().equals(this.userNameField.getText())) return m;
        throw new NoSuchElementException();
    }



    @Override
    public void run() {

    }
}
