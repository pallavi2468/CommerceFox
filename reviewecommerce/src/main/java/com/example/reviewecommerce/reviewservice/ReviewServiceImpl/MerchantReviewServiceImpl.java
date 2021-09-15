package com.example.reviewecommerce.reviewservice.ReviewServiceImpl;

import com.example.reviewecommerce.reviewentity.MerchantReview;
import com.example.reviewecommerce.reviewentity.ProductReview;
import com.example.reviewecommerce.reviewrepository.MerchantReviewRepository;
import com.example.reviewecommerce.reviewrepository.ProductReviewRepository;
import com.example.reviewecommerce.reviewservice.MerchantReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantReviewServiceImpl implements MerchantReviewService {
    @Autowired
    MerchantReviewRepository merchantReviewRepository;

    @Autowired
    ProductReviewRepository productReviewRepository;

    @Override
    public MerchantReview get(Long id) {
        return merchantReviewRepository.findById(id).get();
    }

    @Override
    public MerchantReview save(MerchantReview merchantReview) {

        List<ProductReview> productReviewList = productReviewRepository.findByMerchantId(merchantReview.getMerchantId());
        ProductReview productReview = new ProductReview();

        int sumOfRatings = 0;

        for (int i=0; i<productReviewList.size(); i++)
        {
            productReview = productReviewList.get(i);
            sumOfRatings += productReview.getRating();
        }

        merchantReview.setRating(sumOfRatings/productReviewList.size());

        return merchantReviewRepository.save(merchantReview);
    }

    @Override
    public MerchantReview update(MerchantReview merchantReview) {
        return merchantReviewRepository.save(merchantReview);
    }

}
