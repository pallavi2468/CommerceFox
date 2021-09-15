package com.example.reviewecommerce.reviewcontroller;

import com.example.reviewecommerce.reviewentity.MerchantReview;
import com.example.reviewecommerce.reviewservice.MerchantReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/merchantreview")
public class MerchantReviewController {
    @Autowired
    MerchantReviewService merchantReviewService;

    @GetMapping(value="/{id}")
    public MerchantReview get(@PathVariable(name="id") Long id){
        return merchantReviewService.get(id);
    }

    @PostMapping
    public MerchantReview save(@RequestBody MerchantReview merchantReview){
        return merchantReviewService.save(merchantReview);
    }

    @PutMapping
    public MerchantReview update(@RequestBody MerchantReview merchantReview){
        return merchantReviewService.save(merchantReview);
    }

}
