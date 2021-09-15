package com.example.reviewecommerce.reviewservice;

import com.example.reviewecommerce.reviewentity.ProductReview;

public interface ProductReviewService {
    public ProductReview get(Long id);
    public ProductReview save(ProductReview productReview);
    public ProductReview update(ProductReview productReview);
}
