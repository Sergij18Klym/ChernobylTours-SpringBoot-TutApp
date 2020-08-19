package kly.edu.ChernobylTours.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import kly.edu.ChernobylTours.model.Tours;

@Repository
public interface ToursRepository extends MongoRepository<Tours,String> {
}
