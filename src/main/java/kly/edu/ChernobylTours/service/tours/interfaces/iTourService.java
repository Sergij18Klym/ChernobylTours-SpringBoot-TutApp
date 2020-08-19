package kly.edu.ChernobylTours.service.tours.interfaces;

import kly.edu.ChernobylTours.model.Tours;

import java.util.List;

public interface iTourService {

    Tours create(Tours tours);
    Tours get(String id);
    Tours delete(String id);
    Tours update(Tours tours);
    List<Tours> getAll();

}
