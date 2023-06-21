package mas.Models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DLC extends Product implements Serializable{
    private Game game;

    public DLC(int id, String title, String description, double price, AgeRating ageRating, List<String> tags,
               List<Image> screenShots, List<Achievement> achievements, Game game) {
        super(id, title, description, price, ageRating, tags, screenShots, achievements);
        this.game = game;
    }
    
    void enable(){}
    void disable(){}

    
    // metoda przesłonięta
    @Override
    void buy(Member member) {

    }
}
