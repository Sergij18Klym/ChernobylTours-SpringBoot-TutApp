package kly.edu.ChernobylTours.service.tours.impls;

import kly.edu.ChernobylTours.model.Tours;
import kly.edu.ChernobylTours.repository.ToursRepository;
import kly.edu.ChernobylTours.service.tours.interfaces.iTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements iTourService {

    @Autowired
    ToursRepository toursRepository;

    @Override
    public Tours create(Tours tours) {
        return toursRepository.save(tours);
    }

    @Override
    public Tours get(String id) {
        return toursRepository.findById(id).orElse(null);
    }

    @Override
    public Tours delete(String id) {
        Tours tours = this.get(id);
        toursRepository.deleteById(tours.getId());
        return tours;
    }

    @Override
    public Tours update(Tours tours) {
        return toursRepository.save(tours);
    }

    @Override
    public List<Tours> getAll() {
        return toursRepository.findAll();
    }
}
