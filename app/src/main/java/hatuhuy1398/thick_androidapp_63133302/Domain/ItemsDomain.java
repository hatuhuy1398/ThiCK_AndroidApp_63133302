package hatuhuy1398.thick_androidapp_63133302.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemsDomain implements Serializable {
    private String title;
    private String description;
    private ArrayList<String> picUrl;
    private long price;
    private String oldPrice;
    private int review;
    private double rating;
    private int NumberinCart;
    public ItemsDomain() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(ArrayList<String> picUrl) {
        this.picUrl = picUrl;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberinCart() {
        return NumberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        this.NumberinCart = numberinCart;
    }

    public ItemsDomain(String title, String description, String picUrl, long price, String oldPrice, int review, double rating) {
        this.title = title;
        this.description = description;
        this.picUrl = new ArrayList<>();
        this.price = price;
        this.oldPrice = oldPrice;
        this.review = review;
        this.rating = rating;

    }
}
