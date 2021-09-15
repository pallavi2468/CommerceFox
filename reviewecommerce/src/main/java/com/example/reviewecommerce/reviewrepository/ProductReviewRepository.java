package com.example.reviewecommerce.reviewrepository;

import com.example.reviewecommerce.reviewentity.ProductReview;
import com.example.reviewecommerce.reviewentity.UserReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    public List<ProductReview> findByMerchantId(Long merchantId);
}
