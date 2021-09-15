package com.example.reviewecommerce.reviewservice.ReviewServiceImpl;

import com.example.reviewecommerce.reviewentity.ProductReview;
import com.example.reviewecommerce.reviewentity.UserReview;
import com.example.reviewecommerce.reviewrepository.ProductReviewRepository;
import com.example.reviewecommerce.reviewrepository.UserReviewRepository;
import com.example.reviewecommerce.reviewservice.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    ProductReviewRepository productReviewRepository;

    @Autowired
    UserReviewRepository userReviewRepository;

    @Override
    public ProductReview get(Long id) {
        return productReviewRepository.findById(id).get();
    }

    @Override
    public ProductReview save(ProductReview productReview) {

        List<UserReview> userReviewList = userReviewRepository.findByProductId(productReview.getProductId());
        UserReview userReview = new UserReview();
        int sumOfRatings = 0;
        for(int i=0; i<userReviewList.size(); i++){
            userReview = userReviewList.get(i);

            sumOfRatings += userReview.getRating();
        }

        productReview.setRating(sumOfRatings/userReviewList.size());


        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview update(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

}
