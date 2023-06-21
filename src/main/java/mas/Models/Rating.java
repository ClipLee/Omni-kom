package mas.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Rating implements Serializable {
    private int id;
    public enum ProductRating {
        Star_1(1), Star_2(2), Star_3(3), Star_4(4), Star_5(5);

        public final int rating;

        ProductRating(int rating) {
            this.rating = rating;
        }
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
