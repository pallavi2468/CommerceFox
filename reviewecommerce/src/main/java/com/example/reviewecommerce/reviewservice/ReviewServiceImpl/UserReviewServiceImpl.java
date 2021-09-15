package com.example.reviewecommerce.reviewservice.ReviewServiceImpl;

import com.example.reviewecommerce.reviewentity.UserReview;
import com.example.reviewecommerce.reviewrepository.UserReviewRepository;
import com.example.reviewecommerce.reviewservice.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserReviewServiceImpl implements UserReviewService {

    @Autowired
    UserReviewRepository userReviewRepository;


    @Override
    public UserReview get(Long id) {
        return userReviewRepository.findById(id).get();
    }

    @Override
    public UserReview save(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @Override
    public UserReview update(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @Override
    public void delete(Long id) {
        userReviewRepository.deleteById(id);

    }
}
