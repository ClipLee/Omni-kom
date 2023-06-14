package mas.View;

import mas.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame implements Runnable{


    private JPanel panel;
    private JButton loginButton;
    private JButton registerButton;

    public MainWindow(){
        this.add(panel);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Main.writeToFiles();
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.setSize(350,200);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new LoginWindow());
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new RegisterWindow());
            }
        });
    }

    @Override
    public void run() {
//
    }
}
