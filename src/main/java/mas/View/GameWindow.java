package mas.View;

import mas.Models.Game;
import mas.Models.Member;
import mas.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements Runnable {
    private JPanel mainPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JLabel titleField;
    private JTextArea descriptionArea;
    private JButton buyGameButton;
    private JButton giftGameButton;
    private JLabel ageRatingLabel;
    private JLabel categoryLabel;
    private JLabel priceLabel;

    private final Game game;
    private final Member member;

    public GameWindow(Game game, Member member) {
        this.game = game;
        this.member = member;

        this.add(mainPanel);

        loadGameDetails();

        this.setVisible(true);
        this.setSize(800, 500);
        buyGameButton.addActionListener(actionEvent -> {
            JCheckBox terms = new JCheckBox("I agree to terms of service");
            String message = this.game.getTitle() + ", price: " + this.game.getPrice() + "\n Do you want to buy this game?";
            Object[] choices = new Object[]{"Buy", "Cancel"};
            int i = JOptionPane.showOptionDialog(this, new Object[]{message, terms}, "Buy the game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
            if (i==0){
                if (member.getWalletBalance()<game.getPrice())
                    JOptionPane.showMessageDialog(this, "You don't have enough money", "No money", JOptionPane.WARNING_MESSAGE);
                else if (terms.isSelected() ) {
                    this.game.buy(member);
                    JOptionPane.showMessageDialog(this, "Success, game has been added to your library", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    Utils.closeWindow(this);
                } else
                    JOptionPane.showMessageDialog(this, "You need to agree to terms of service", "Warning", JOptionPane.WARNING_MESSAGE);
            }


        });
        giftGameButton.addActionListener(actionEvent -> {
            try {
                SwingUtilities.invokeLater(new BuyGameWindow(game, member));
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "You don't have no friends!", "No friends", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void createUIComponents() {
        this.titleField = new JLabel();
        this.ageRatingLabel = new JLabel();
        this.descriptionArea = new JTextArea();
        this.categoryLabel = new JLabel();
        this.priceLabel = new JLabel();
    }

    private void loadGameDetails() {
        this.titleField.setText(game.getTitle());
        this.ageRatingLabel.setText(game.getAgeRating().name());
        this.descriptionArea.setText(game.getDescription());
        this.categoryLabel.setText(game.getGenres().toString());
        this.priceLabel.setText(String.valueOf(game.getPrice()));
        revalidate();
    }

    @Override
    public void run() {

    }
}
