package com.example.nxttrendz1.model;

import com.example.nxttrendz1.model.Product;
import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewId;
    @Column(name = "reviewcontent")
    String reviewContent;
    @Column(name = "rating")
    int rating;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    public Review() {
    }

    public Review(int reviewId, String reviewContent, int rating, Product product) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.product = product;

    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;

    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

// Write your code here