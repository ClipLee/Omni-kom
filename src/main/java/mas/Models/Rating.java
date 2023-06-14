package mas.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Rating implements Serializable {
    private int id;
    private enum ProductRating {
        Star_1, Star_2, Star_3, Star_4, Star_5
    }
    private ProductRating productRating;
    private String title, body;
    private Member author;
    private Product product;


    public Rating(int id, ProductRating productRating, String title, String body, Member author, Product product) {
        this.id = id;
        this.productRating = productRating;
        this.title = title;
        this.body = body;
        this.author = author;
        this.product = product;
    }


    void edit(){}
    void delete(){}

}
