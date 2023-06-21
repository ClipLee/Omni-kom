package mas.View;

import mas.Main;
import mas.Models.Game;
import mas.Models.Member;
import mas.Models.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame implements Runnable {
    private JPanel panel;
    private JList list1;
    private JButton showGameButton;
    private JButton playGameButton;
    private JTextArea descriptionArea;
    private JScrollPane scrollPane;

    private Game selectedProduct;

    private Member member;

    public MainWindow(Member member) {
        this.member = member;
        this.add(panel);

        this.setVisible(true);
        this.setSize(800, 500);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Main.writeToFiles();
                System.exit(0);
            }
        });
        showGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkAgeAndShow();
            }
        });
    }

    @Override
    public void run() {
        //
    }

    private void checkAgeAndShow() {
        if (member.getAge() < selectedProduct.getAgeRating().i) {
            JOptionPane.showMessageDialog(this, "Unfortunately, you are too young to view this game.");
        } else SwingUtilities.invokeLater(new GameWindow(selectedProduct, member));
    }

    private void createUIComponents() {
        this.list1 = new JList(Main.productList.toArray());
        this.list1.setLayoutOrientation(JList.VERTICAL);
        this.list1.setSelectedIndex(-1);
        this.list1.addListSelectionListener(e -> {
            JList source = (JList) e.getSource();
            selectedProduct = (Game) source.getSelectedValue();
            descriptionArea.setText(selectedProduct.getDescription());
        });

    }
}
