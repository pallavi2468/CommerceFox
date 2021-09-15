package com.example.reviewecommerce.reviewrepository;

import com.example.reviewecommerce.reviewentity.MerchantReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantReviewRepository extends CrudRepository<MerchantReview, Long> {
}
