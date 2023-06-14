package mas.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Achievement implements Serializable {
    private int id;
    private String title, description;
    private boolean isUnlocked, isSecret;
    private double rarity;

    private Product product;

    void countRarity(){}
    void viewAchievements(){}
    void show(){}
    void hide(){}
}
