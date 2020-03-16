package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    public Iterable<Movie> findMovieByTitle(String title);

    public Iterable<Movie> findMovieByReleaseYear(int releaseYear);

    public Iterable<Movie> findMovieByActors(String actor);

    public Iterable<Movie> findMovieByRating(double rating);

    public Page<Movie> findAllBy(Pageable pageable);
}
