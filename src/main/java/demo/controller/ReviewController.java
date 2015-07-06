package demo.controller;

import demo.exception.ReviewException;
import demo.model.Review;
import demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@RequestBody Review review) {return reviewRepository.save(review);}

    @RequestMapping(method = RequestMethod.GET)
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<Review>();
        Iterator<Review> iterator = reviewRepository.findAll().iterator();

        while (iterator.hasNext()) reviews.add(iterator.next());

        return reviews;
    }

    @RequestMapping(value= "/{id}", method = GET)
    public Review getById(@PathVariable Long id) {
        Review review = reviewRepository.findOne(id);

        if (review == null) throw new ReviewException(id);

        return review;
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Review review = reviewRepository.findOne(id);

        if (review == null) throw new ReviewException(id);

        reviewRepository.delete(id);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public Review updateById(@PathVariable Long id, @RequestBody Review review) {
        if (reviewRepository.findOne(id) == null) throw new ReviewException(id);

        review = reviewRepository.save(review);

        return review;
    }
}
