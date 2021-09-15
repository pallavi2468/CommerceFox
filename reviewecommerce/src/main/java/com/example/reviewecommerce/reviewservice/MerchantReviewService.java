package com.example.reviewecommerce.reviewservice;

import com.example.reviewecommerce.reviewentity.MerchantReview;

public interface MerchantReviewService {
    public MerchantReview get(Long id);
    public MerchantReview save(MerchantReview merchantReview);
    public MerchantReview update(MerchantReview merchantReview);
}
