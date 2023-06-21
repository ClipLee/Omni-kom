package mas.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mas.View.LoginWindow;
import mas.View.RegisterWindow;

import javax.swing.*;
import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = true)
public class Guest extends User implements Serializable {

    public void register() {
        SwingUtilities.invokeLater(new RegisterWindow());
    }

    public void login() {
        SwingUtilities.invokeLater(new LoginWindow());
    }
}
