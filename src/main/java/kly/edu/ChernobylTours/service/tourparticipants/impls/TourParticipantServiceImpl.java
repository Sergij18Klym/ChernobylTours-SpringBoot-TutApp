package kly.edu.ChernobylTours.service.tourparticipants.impls;

import kly.edu.ChernobylTours.model.TourParticipants;
import kly.edu.ChernobylTours.repository.TourParticipantsRepository;
import kly.edu.ChernobylTours.service.tourparticipants.interfaces.iTourParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourParticipantServiceImpl implements iTourParticipantService {

    @Autowired
    TourParticipantsRepository tourParticipantsRepository;

    @Override
    public TourParticipants create(TourParticipants tourParticipants) {
        return tourParticipantsRepository.save(tourParticipants);
    }

    @Override
    public TourParticipants get(String id) {
        return tourParticipantsRepository.findById(id).orElse(null);
    }

    @Override
    public TourParticipants delete(String id) {
        TourParticipants tourParticipants = this.get(id);
        tourParticipantsRepository.deleteById(tourParticipants.getId());
        return tourParticipants;
    }

    @Override
    public TourParticipants update(TourParticipants tourParticipants) {
        return tourParticipantsRepository.save(tourParticipants);
    }

    @Override
    public List<TourParticipants> getAll() {
        return tourParticipantsRepository.findAll();
    }
}
