package kly.edu.ChernobylTours.dao.participants.interfaces;

import kly.edu.ChernobylTours.model.Participants;

import java.util.List;

public interface iDaoParticipants {

    Participants create(Participants participants);
    Participants get(String id);
    Participants delete(String id);
    Participants update(Participants participants);
    List<Participants> getAll();

}
