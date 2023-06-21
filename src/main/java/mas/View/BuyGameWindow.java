package mas.View;

import mas.Models.Game;
import mas.Models.Member;
import mas.Utils;

import javax.swing.*;

public class BuyGameWindow extends JFrame implements Runnable {
    private JPanel panel;
    private JCheckBox termsCheckBox;
    private JButton buyButton;
    private JButton cancelButton;
    private JList friendList;
    private JLabel titleLabel;
    private JLabel priceLabel;

    private Game game;
    private Member member, selectedFriend;

    public BuyGameWindow(Game game, Member member) {
        this.game = game;
        this.member = member;
        this.add(panel);

        loadGameDetails();

        this.setVisible(true);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        buyButton.addActionListener(actionEvent -> {
            if (termsCheckBox.isSelected()) {
                if (member.getWalletBalance() < game.getPrice())
                    JOptionPane.showMessageDialog(this, "You don't have enough money", "No money", JOptionPane.WARNING_MESSAGE);
                else {
                    this.game.buy(member);
                    JOptionPane.showMessageDialog(this, "Success, game has been added to your library", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    Utils.closeWindow(this);
                }
            } else
                JOptionPane.showMessageDialog(this, "You need to agree to terms of service", "Warning", JOptionPane.WARNING_MESSAGE);
        });
        cancelButton.addActionListener(actionEvent -> Utils.closeWindow(this));
    }

    private void createUIComponents() {
        if (member.getFriends().isEmpty()) throw new NullPointerException();
        this.friendList = new JList(member.getFriends().toArray());
        this.friendList.addListSelectionListener(e -> {
            JList source = (JList) e.getSource();
            selectedFriend = (Member) source.getSelectedValue();
        });

    }

    private void loadGameDetails() {
        this.titleLabel.setText(game.getTitle());
        this.priceLabel.setText(String.valueOf(game.getPrice()));
        revalidate();
    }

    @Override
    public void run() {

    }
}
