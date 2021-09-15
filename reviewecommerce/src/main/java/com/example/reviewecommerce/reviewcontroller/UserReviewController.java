package com.example.reviewecommerce.reviewcontroller;

import com.example.reviewecommerce.reviewentity.UserReview;
import com.example.reviewecommerce.reviewservice.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userreview")
public class UserReviewController {
    @Autowired
    UserReviewService userReviewService;

    @GetMapping(value="/{id}")
    public UserReview get(@PathVariable(name="id") Long id){
        return userReviewService.get(id);
    }

    @PostMapping
    public UserReview save(@RequestBody UserReview userReview){
        return userReviewService.save(userReview);
    }

    @PutMapping
    public UserReview update(@RequestBody UserReview userReview){
        return userReviewService.save(userReview);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name="id") Long id){
        userReviewService.delete(id);
        //????@RequestParam

    }
}
