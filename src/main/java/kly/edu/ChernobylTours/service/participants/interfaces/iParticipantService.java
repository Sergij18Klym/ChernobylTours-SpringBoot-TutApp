package kly.edu.ChernobylTours.service.participants.interfaces;

import kly.edu.ChernobylTours.model.Participants;

import java.util.List;

public interface iParticipantService {

    Participants create(Participants participants);
    Participants get(String id);
    Participants delete(String id);
    Participants update(Participants participants);
    List<Participants> getAll();

}
