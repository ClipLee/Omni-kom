package mas.Models;

import lombok.Data;

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

    void countRarity(){}
    void viewAchievements(){}
    void show(){}
    void hide(){}
}
