package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    public boolean existsUserByEmail(String email);

    public Iterable<User> findUserByName (String name);
}
