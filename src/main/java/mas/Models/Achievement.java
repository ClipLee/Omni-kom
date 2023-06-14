package mas.Models;

import lombok.Data;

@Data
public class Achievement {
    private int id;
    private String title, description;
    private boolean isUnlocked, isSecret;
    private double rarity;

    Product product;
}
