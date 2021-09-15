package com.example.reviewecommerce.reviewservice;

import com.example.reviewecommerce.reviewentity.ProductReview;
import com.example.reviewecommerce.reviewentity.UserReview;

public interface UserReviewService {
    public UserReview get(Long id);
    public UserReview save(UserReview userReview);
    public UserReview update(UserReview userReview);
    public void delete(Long id);
}
