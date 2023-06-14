package mas.Models;

import java.util.List;

import lombok.Data;

@Data
public abstract class Product{
    protected int id;
    protected String title, description;
    protected double price;
    protected AgeRating ageRating;

    protected List<String> tags;
    protected List<Image> screenShots;
    protected List<Achievement> achievements;

    public Product(int id, String title, String description, double price, AgeRating ageRating, List<String> tags,
            List<Image> screenShots, List<Achievement> achievements) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.ageRating = ageRating;
        this.tags = tags;
        this.screenShots = screenShots;
        this.achievements = achievements;
    }

    
    void buy(){}
    void gift(){}
    void searchStore(){}
    void browseCatalog(){}
    void viewCatalog(){}
    
}
