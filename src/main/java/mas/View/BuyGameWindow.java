package mas.View;

import mas.Models.Game;
import mas.Models.Member;
import mas.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyGameWindow extends JFrame implements Runnable{
    private JPanel panel;
    private JCheckBox termsCheckBox;
    private JButton buyButton;
    private JButton cancelButton;
    private JList friendList;
    private JLabel titleLabel;
    private JLabel priceLabel;

    private Game game;
    private Member member, selectedFriend;

    public BuyGameWindow(Game game, Member member){
        this.game = game;
        this.member = member;
        this.add(panel);

        this.setVisible(true);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        buyButton.addActionListener(actionEvent -> {
            if (termsCheckBox.isSelected()) {
                this.game.buy();
                Utils.closeWindow(this);
            }
            else JOptionPane.showMessageDialog(this, "You need to agree to terms of service", "Warning", JOptionPane.WARNING_MESSAGE);
        });
    }

    private void createUIComponents() {
            if (member.getFriends().isEmpty()) throw new NullPointerException();
            this.friendList = new JList(member.getFriends().toArray());
            this.friendList.addListSelectionListener(e->{
                JList source = (JList) e.getSource();
                selectedFriend = (Member) source.getSelectedValue();
            });

    }

    @Override
    public void run() {

    }
}