package kz.attractorschool.moviereviewrr.controller;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    MovieRepository mr;

    @Autowired
    ReviewRepository rr;

    @Autowired
    UserRepository ur;

    @GetMapping("/1/1/{email}")
    public boolean existsUserByEmail1(@PathVariable("email") String email){
        return ur.existsUserByEmail(email);
    }

    @GetMapping("/1/2/1/{id}")
    public Iterable<Review> findUserByEmail1(@PathVariable("id") String id){
                                              // @PathVariable("title") String title){
        return rr.findReviewByReviewerId(id);
    }

    @GetMapping("/1/2/2/{id1}")
    public Iterable<Review> findUserByEmail2(@PathVariable("id1") String id1){
        // @PathVariable("title") String title){
        return rr.findReviewByMovieId(id1);
    }

    @GetMapping("/1/3/{idr}/{idm}")
    public boolean existReview(@PathVariable("idr") String idr,
                               @PathVariable("idm") String idm){
        return rr.existsByReviewerIdAndMovieId(idr,idm);
    }

    @GetMapping("/1/4/1/{title}")
    public Iterable<Movie> findMovieByTitle(@PathVariable("title") String title){
        return mr.findMovieByTitle(title);
    }

    @GetMapping("/1/4/2/{releaseYear}")
    public Iterable<Movie> findMovieByYear(@PathVariable("releaseYear") int releaseYear){
        return mr.findMovieByReleaseYear(releaseYear);
    }

    @GetMapping("/1/4/3/{actor}")
    public Iterable<Movie> findMovieByActor(@PathVariable("actor") String actor){
        return mr.findMovieByActors(actor);
    }

    @GetMapping("/1/4/4/{rating}")
    public Iterable<Movie> findMovieByRating(@PathVariable("rating") double rating){
        return mr.findMovieByRating(rating);
    }

    @GetMapping("/1/5/1")
    public Page<Movie> findMovie(){
        Sort sortBy = Sort.by(Sort.Order.asc("title"));
        int page = 1;
        int count = 3;

        Pageable pageable = PageRequest.of(page,count,sortBy);
        Page<Movie> result = mr.findAllBy(pageable);
        return result;
    }

    @GetMapping("/1/5/2")
    public Page<Movie> findMovie1(){
        Sort sortBy = Sort.by(Sort.Order.asc("rating"));
        int page = 1;
        int count = 3;

        Pageable pageable = PageRequest.of(page,count,sortBy);
        Page<Movie> result = mr.findAllBy(pageable);
        return result;
    }

    @GetMapping("/1/6/{name}")
    public Iterable<User> findUserByName(@PathVariable("name") String name){
        return ur.findUserByName(name);
    }

    @GetMapping("/1/7/{id}")
    public Iterable<Review> findRevieewByMovie(@PathVariable("id") String id){
        return rr.findReviewByMovieId(id);
    }

}
