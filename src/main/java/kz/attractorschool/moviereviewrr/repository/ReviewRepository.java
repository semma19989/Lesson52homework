package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Review;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {

    //@Query("{'reviewer' : {'id' : '?0'}}, {'movie' : {'id' : '?1'}}")
    boolean existsByReviewerIdAndMovieId(String id1, String id2);

    List<Review> findReviewByReviewerId(String id);

    List<Review> findReviewByMovieId(String id);

    //Iterable<Review> findReviewByMovieId1(String id);
    //Abytali uuluSyimuk

}
