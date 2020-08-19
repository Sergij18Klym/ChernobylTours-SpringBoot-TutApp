package kly.edu.ChernobylTours.controller.rest;

import kly.edu.ChernobylTours.model.Participants;
import kly.edu.ChernobylTours.model.TourParticipants;
import kly.edu.ChernobylTours.model.Tours;
import kly.edu.ChernobylTours.service.participants.impls.ParticipantServiceImpl;
import kly.edu.ChernobylTours.service.tourparticipants.impls.TourParticipantServiceImpl;
import kly.edu.ChernobylTours.service.tours.impls.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/participants")
@RestController
public class ParticipantsRestController {

    @Autowired
    ParticipantServiceImpl participantService;
    @Autowired
    TourServiceImpl tourService;
    @Autowired
    TourParticipantServiceImpl tourParticipantService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Participants> getParticipants() {
        return participantService.getAll();
    }

    @RequestMapping(value = "/list/tours", method = RequestMethod.GET)
    List<Tours> getTours() {
        return tourService.getAll();
    }

    @RequestMapping(value = "/list/tp", method = RequestMethod.GET)
    List<TourParticipants> getTp() {
        return tourParticipantService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Participants getParticipants(@PathVariable("id") String id){
        return participantService.get(id);
    }


}
