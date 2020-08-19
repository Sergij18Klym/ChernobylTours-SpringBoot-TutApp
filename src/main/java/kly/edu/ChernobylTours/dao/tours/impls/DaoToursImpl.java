package kly.edu.ChernobylTours.dao.tours.impls;

import kly.edu.ChernobylTours.dao.tours.interfaces.iDaoTours;
import kly.edu.ChernobylTours.model.Tours;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoToursImpl implements iDaoTours {

    @Autowired
    DaoToursImpl daoTours;

    @Override
    public Tours create(Tours tours) {
        return null;
    }

    @Override
    public Tours get(String id) {
        return null;
    }

    @Override
    public Tours delete(String id) {
        return null;
    }

    @Override
    public Tours update(Tours tours) {
        return null;
    }

    @Override
    public List<Tours> getAll() {
        return null;
    }
}
