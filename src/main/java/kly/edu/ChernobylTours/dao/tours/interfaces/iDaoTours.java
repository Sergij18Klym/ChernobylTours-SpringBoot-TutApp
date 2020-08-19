package kly.edu.ChernobylTours.dao.tours.interfaces;

import kly.edu.ChernobylTours.model.Tours;

import java.util.List;

public interface iDaoTours {

    Tours create(Tours tours);
    Tours get(String id);
    Tours delete(String id);
    Tours update(Tours tours);
    List<Tours> getAll();

}
