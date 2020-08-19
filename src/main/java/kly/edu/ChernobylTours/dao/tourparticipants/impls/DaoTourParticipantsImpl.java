package kly.edu.ChernobylTours.dao.tourparticipants.impls;

import kly.edu.ChernobylTours.dao.tourparticipants.interfaces.iDaoTourParticipants;
import kly.edu.ChernobylTours.model.TourParticipants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoTourParticipantsImpl implements iDaoTourParticipants {

    @Autowired
    DaoTourParticipantsImpl daoTourParticipants;

    @Override
    public TourParticipants create(TourParticipants tourParticipants) {
        return null;
    }

    @Override
    public TourParticipants get(String id) {
        return null;
    }

    @Override
    public TourParticipants delete(String id) {
        return null;
    }

    @Override
    public TourParticipants update(TourParticipants tourParticipants) {
        return null;
    }

    @Override
    public List<TourParticipants> getAll() {
        return null;
    }
}
