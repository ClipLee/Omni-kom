package mas.Models;

import lombok.Data;
import mas.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Achievement implements Serializable {
    private int id;
    private String title, description;
    private boolean isUnlocked, isSecret;
    private double rarity;

    private Product product;
    private List<Achieving> achievings;

    public Achievement(int id, String title, String description, boolean isUnlocked, boolean isSecret, Product product) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isUnlocked = isUnlocked;
        this.isSecret = isSecret;
        this.product = product;

        achievings = new ArrayList<>();
    }

    public static void countRarity(Achievement achievement) {
        int hasGame = 0;
        int hasAchieved = 0;
        for (Member m : Main.userList) {
            for (Transaction t : m.getTransactions()) {
                if (t.getProduct().getId() == achievement.getProduct().getId()) {
                    hasGame++;
                    for (Achieving a : m.getAchievements()) {
                        if (a.getAchievement().getId() == achievement.getId()){
                            hasAchieved++;
                        }
                    }
                }
            }
            achievement.setRarity((double) hasAchieved / hasGame);
        }
    }

    public static void viewAchievements() {
        Main.achievementList.forEach(System.out::println);
    }

    void show() {
    }

    void hide() {
    }
}
