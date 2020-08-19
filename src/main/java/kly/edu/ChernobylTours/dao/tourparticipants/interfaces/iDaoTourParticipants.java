package kly.edu.ChernobylTours.dao.tourparticipants.interfaces;

import kly.edu.ChernobylTours.model.TourParticipants;

import java.util.List;

public interface iDaoTourParticipants {

    TourParticipants create(TourParticipants tourParticipants);
    TourParticipants get(String id);
    TourParticipants delete(String id);
    TourParticipants update(TourParticipants tourParticipants);
    List<TourParticipants> getAll();

}
