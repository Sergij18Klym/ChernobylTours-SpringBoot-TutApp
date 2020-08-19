package kly.edu.ChernobylTours.repository;

import kly.edu.ChernobylTours.model.TourParticipants;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourParticipantsRepository extends MongoRepository<TourParticipants,String> {
}
