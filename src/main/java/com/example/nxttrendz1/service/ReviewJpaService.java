package com.example.nxttrendz1.service;

import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> li = reviewJpaRepository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(li);
        return reviews;
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review re = reviewJpaRepository.findById(reviewId).get();
            return re;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updateReview(int reviewId, Review review) {
        try {
            Review newReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                newReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                newReview.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                Product product = review.getProduct();
                int productId = product.getProductId();
                Product newProduct = productJpaRepository.findById(productId).get();
                newReview.setProduct(newProduct);
            }
            reviewJpaRepository.save(newReview);
            return newReview;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public Review addReview(Review review) {
        Product p = review.getProduct();
        int productId = p.getProductId();
        try {

            Product newProduct = productJpaRepository.findById(productId).get();
            review.setProduct(newProduct);

            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Product getReviewProduct(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            if (review.getProduct() != null) {
                Product product = review.getProduct();
                return product;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

}

// Write your code here