package mas.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Genre implements Serializable {
    private int id;
    private String name;
    
    
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
