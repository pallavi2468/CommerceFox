package com.example.reviewecommerce.reviewentity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MerchantReview {

    @Id
    @GeneratedValue
    private Long merchantReviewId;
//    private String customerId;
    private Long merchantId;
    private float rating;

    public Long getMerchantReviewId() {
        return merchantReviewId;
    }

    public void setMerchantReviewId(Long merchantReviewId) {
        this.merchantReviewId = merchantReviewId;
    }

//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
