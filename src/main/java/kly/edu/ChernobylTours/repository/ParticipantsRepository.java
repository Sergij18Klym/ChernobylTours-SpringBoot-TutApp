package kly.edu.ChernobylTours.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import kly.edu.ChernobylTours.model.Participants;

@Repository
public interface ParticipantsRepository extends MongoRepository<Participants,String> {
}
