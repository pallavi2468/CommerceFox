package com.example.reviewecommerce.reviewentity;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductReview {
    @Id
    @GeneratedValue
    private Long productReviewId;
//    private Long userId;
    private Long merchantId;
    private String productId;
    private float rating;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    public Long getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(Long productReviewId) {
        this.productReviewId = productReviewId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
