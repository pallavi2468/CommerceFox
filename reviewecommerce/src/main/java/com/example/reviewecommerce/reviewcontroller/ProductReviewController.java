package com.example.reviewecommerce.reviewcontroller;


import com.example.reviewecommerce.reviewentity.MerchantReview;
import com.example.reviewecommerce.reviewentity.ProductReview;
import com.example.reviewecommerce.reviewservice.MerchantReviewService;
import com.example.reviewecommerce.reviewservice.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/productreview")
public class ProductReviewController {
    @Autowired
    ProductReviewService productReviewService;

    @GetMapping(value="/{id}")
    public ProductReview get(@PathVariable(name="id") Long id){
        return productReviewService.get(id);
    }

    @PostMapping
    public ProductReview save(@RequestBody ProductReview productReview){
        return productReviewService.save(productReview);
    }

    @PutMapping
    public ProductReview update(@RequestBody ProductReview productReview){
        return productReviewService.save(productReview);
    }

}
