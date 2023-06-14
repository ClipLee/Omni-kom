package mas.Models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Game extends Product implements Serializable {
    
    protected List<Genre> genres;
    protected List<DLC> dlcs;

    public Game(int id, String title, String description, double price, AgeRating ageRating, List<String> tags,
            List<Image> screenShots, List<Achievement> achievements, List<Genre> genres) {
        super(id, title, description, price, ageRating, tags, screenShots, achievements);
        this.genres = genres;
    }

    void viewGame(){}
    void play(){}
}
