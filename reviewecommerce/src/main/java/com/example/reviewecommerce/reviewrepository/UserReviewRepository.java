package com.example.reviewecommerce.reviewrepository;

import com.example.reviewecommerce.reviewentity.UserReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends CrudRepository<UserReview, Long> {
    public List<UserReview> findByProductId(String productId);
}
