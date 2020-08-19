package kly.edu.ChernobylTours.dao.participants.impls;

import kly.edu.ChernobylTours.dao.participants.interfaces.iDaoParticipants;
import kly.edu.ChernobylTours.model.Participants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoParticipantsImpl implements iDaoParticipants {

    @Autowired
    DaoParticipantsImpl daoParticipants;

    @Override
    public Participants create(Participants participants) {
        return null;
    }

    @Override
    public Participants get(String id) {
        return null;
    }

    @Override
    public Participants delete(String id) {
        return null;
    }

    @Override
    public Participants update(Participants participants) {
        return null;
    }

    @Override
    public List<Participants> getAll() {
        return null;
    }
}
