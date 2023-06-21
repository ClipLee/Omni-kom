package mas.View;

import mas.Main;
import mas.Models.Guest;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WelcomeWindow extends JFrame implements Runnable {


    private JPanel panel;
    private JButton loginButton;
    private JButton registerButton;

    public WelcomeWindow() {
        this.add(panel);

        Guest guest = new Guest();

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
        this.setSize(350, 200);
        loginButton.addActionListener(actionEvent -> guest.login());
        registerButton.addActionListener(actionEvent -> guest.register());
    }

    @Override
    public void run() {
//
    }
}
