package kly.edu.ChernobylTours.service.participants.impls;

import kly.edu.ChernobylTours.datastorage.DataFake;
import kly.edu.ChernobylTours.model.Participants;
import kly.edu.ChernobylTours.repository.ParticipantsRepository;
import kly.edu.ChernobylTours.service.participants.interfaces.iParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements iParticipantService {

    @Autowired
    ParticipantsRepository participantsRepository;

    @Autowired
    DataFake dataFake0;

    @Override
    public Participants create(Participants participants) {
        return participantsRepository.save(participants);
    }

    @Override
    public Participants get(String id) {
        return participantsRepository.findById(id).orElse(null);
    }

    @Override
    public Participants delete(String id) {
        Participants participants = this.get(id);
        participantsRepository.deleteById(participants.getId());
        return participants;
    }

    @Override
    public Participants update(Participants participants) {
        return participantsRepository.save(participants);
    }

    @Override
    public List<Participants> getAll() {
        return participantsRepository.findAll();
    }

    public void reloadData(){
        dataFake0.init();
    }
}
