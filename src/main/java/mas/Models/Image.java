package mas.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Image implements Serializable {
    private int height, width;
    private String imageType, imagePath;
    
    
    public Image(int height, int width, String imageType, String imagePath) {
        this.height = height;
        this.width = width;
        this.imageType = imageType;
        this.imagePath = imagePath;
    }

    
}
