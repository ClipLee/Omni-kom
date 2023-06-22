package mas.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * Klasa abstrakcyjna
 */
@Data
public abstract class Product implements Serializable {
    protected int id;
    protected String title, description;
    protected double price;
    protected AgeRating ageRating;

    protected List<String> tags;
    protected List<Image> screenShots;
    protected List<Achievement> achievements;

    protected List<Transaction> transactions;
    protected List<Image> images;

    //for Lombok
    public Product(){}

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

        transactions = new ArrayList<>();
        images = new ArrayList<>();
    }

    /**
     *
     * Metoda przesłonięta
     */
    abstract void buy(Member member);
    void gift(){}
    void searchStore(){}
    void browseCatalog(){}
    void viewLibrary(){}
    
}
