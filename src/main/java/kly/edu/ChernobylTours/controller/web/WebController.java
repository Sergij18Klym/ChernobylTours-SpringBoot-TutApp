package kly.edu.ChernobylTours.controller.web;

import kly.edu.ChernobylTours.form.ParticipantsForm;
import kly.edu.ChernobylTours.form.TourParticipantsForm;
import kly.edu.ChernobylTours.form.ToursForm;
import kly.edu.ChernobylTours.model.Participants;
import kly.edu.ChernobylTours.model.TourParticipants;
import kly.edu.ChernobylTours.model.Tours;
import kly.edu.ChernobylTours.service.participants.impls.ParticipantServiceImpl;
import kly.edu.ChernobylTours.service.tourparticipants.impls.TourParticipantServiceImpl;
import kly.edu.ChernobylTours.service.tours.impls.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    ParticipantServiceImpl participantService;
    @Autowired
    TourServiceImpl tourService;
    @Autowired
    TourParticipantServiceImpl tourParticipantService;

    Map<String, String> movs;
    Map<String, String> movs2;
    @PostConstruct
    void init(){
        movs = new HashMap<>();
        movs2 = new HashMap<>();
        for (Participants participants:participantService.getAll()) {
            movs.put(participants.getId(), participants.getName());
        }
        for(Tours tours:tourService.getAll()){
            movs2.put(tours.getId(), tours.getId());
        }
    }

@RequestMapping("/participants")
    String showAllParticipants(Model model){
        model.addAttribute("modelList",participantService.getAll());
        return "participantList";
    }

@RequestMapping("/tourparticipants")
    String showAllTourParticipants(Model model){
        model.addAttribute("modelList",tourParticipantService.getAll());
        return "tourParticipantList";
    }

@RequestMapping("/tours")
    String showAllTours(Model model){
        model.addAttribute("modelList",tourService.getAll());
        return "tourList";
    }

@RequestMapping(value = "participants/delete/{id}", method = RequestMethod.GET)
    String deleteParticipant(@PathVariable("id") String id, Model model){
        participantService.delete(id);
        model.addAttribute("modelList", participantService.getAll());
        return "redirect:/participants";
    }

@RequestMapping(value = "tourparticipants/delete/{id}", method = RequestMethod.GET)
    String deleteTourParticipant(@PathVariable("id") String id, Model model){
        tourParticipantService.delete(id);
        model.addAttribute("modelList", tourParticipantService.getAll());
        return "redirect:/tourparticipants";
    }

@RequestMapping(value = "tours/delete/{id}", method = RequestMethod.GET)
    String deleteTour(@PathVariable("id") String id, Model model){
        tourService.delete(id);
        model.addAttribute("modelList", tourService.getAll());
        return "redirect:/tours";
    }

@RequestMapping(value = "participants/edit/{id}", method = RequestMethod.GET)
    String editParticipant(@PathVariable("id") String id, Model model){
        Participants participants = participantService.get(id);
        ParticipantsForm participantsForm = new ParticipantsForm(
            participants.getId(),
            participants.getName(),
            participants.getEmail(),
            participants.getPhone(),
            participants.getPassport()
        );
        model.addAttribute("participantsForm", participantsForm);
        return "edit-participant";
}

@RequestMapping(value = "participants/edit/{id}", method = RequestMethod.POST)
    public String editParticipant(Model model,
           @ModelAttribute("participantForm") ParticipantsForm participantsForm){
        Participants participants = new Participants();
        participants.setId(participantsForm.getId());
        participants.setName(participantsForm.getName());
        participants.setEmail(participantsForm.getEmail());
        participants.setPhone(participantsForm.getPhone());
        participants.setPassport(participantsForm.getPassport());
        participantService.update(participants);
        model.addAttribute("participants", participantService.getAll());
        return "redirect:/participants";
}

@RequestMapping(value = "tourparticipants/edit/{id}", method = RequestMethod.GET)
    String editTourParticipant(@PathVariable("id") String id, Model model){
        TourParticipants tourParticipants = tourParticipantService.get(id);
        TourParticipantsForm tourParticipantsForm = new TourParticipantsForm(
            tourParticipants.getId(),
            tourParticipants.getParticipant(),
            tourParticipants.getTour(),
            tourParticipants.getCost(),
            tourParticipants.isPermission()
        );
        model.addAttribute("movs",movs);
        model.addAttribute("tourParticipantsForm", tourParticipantsForm);
        return "edit-tourparticipant";
    }

    @RequestMapping(value = "tourparticipants/edit/{id}", method = RequestMethod.POST)
    public String editTourParticipant(Model model,
           @ModelAttribute("tourParticipantForm") TourParticipantsForm tourParticipantsForm){
        TourParticipants tourParticipants = new TourParticipants();
        tourParticipants.setId(tourParticipantsForm.getId());
        tourParticipants.setParticipant(tourParticipants.getParticipant());
        tourParticipants.setTour(tourParticipants.getTour());
        tourParticipants.setCost(tourParticipants.getCost());
        tourParticipants.setPermission(tourParticipants.isPermission());
        tourParticipantService.update(tourParticipants);
        model.addAttribute("tourParticipants", tourParticipantService.getAll());
        return "redirect:/tourparticipants";
    }

    @RequestMapping(value = "tours/edit/{id}", method = RequestMethod.GET)
    String editTour(@PathVariable("id") String id, Model model){
        Tours tours = tourService.get(id);
        ToursForm toursForm = new ToursForm(
                tours.getId(),
                tours.getTourTyp(),
                tours.getStartDate()
        );
        model.addAttribute("toursForm", toursForm);
        return "edit-tour";
    }

    @RequestMapping(value = "tours/edit/{id}", method = RequestMethod.POST)
    public String editTour(Model model,
           @ModelAttribute("toursForm") ToursForm toursForm){
        Tours tours = new Tours();
        tours.setId(toursForm.getId());
        tours.setTourTyp(toursForm.getTourTyp());
        tours.setStartDate(toursForm.getStartDate());
        tourService.update(tours);
        model.addAttribute("tours", tourService.getAll());
        return "redirect:/tours";
    }

@RequestMapping(value = "/create-participant", method = RequestMethod.GET)
    public String createParticipant(Model model) {
        ParticipantsForm participantsForm = new ParticipantsForm();
        model.addAttribute("participantsForm", participantsForm);
        return "create-participant";
}

@RequestMapping(value = "/create-participant", method = RequestMethod.POST)
    public String createParticipant(Model model,
           @ModelAttribute("participantsForm") ParticipantsForm participantsForm) {
        Participants participants = new Participants();
        participants.setId(participantsForm.getId());
        participants.setName(participantsForm.getName());
        participants.setPhone(participantsForm.getPhone());
        participants.setEmail(participantsForm.getEmail());
        participants.setPassport(participantsForm.getPassport());
        participantService.create(participants);
        model.addAttribute("participants", participantService.getAll());
        return "redirect:/create-tourparticipant";
}

@RequestMapping(value = "/create-tourparticipant", method = RequestMethod.GET)
    public String createTourParticipant(Model model) {
        TourParticipantsForm tourParticipantsForm = new TourParticipantsForm();
        /*
        for(Participants participants:participantService.getAll()){
            movs.put(participants.getId(), participants.getName());
        }
        for(Tours tours:tourService.getAll()){
            movs2.put(tours.getId(), tours.getTourTyp());
        }
        */
        model.addAttribute("movs", movs);
        model.addAttribute("movs2", movs2);
        model.addAttribute("tourParticipantsForm", tourParticipantsForm);
        return "create-tourparticipant";
}

@RequestMapping(value = "/create-tourparticipant", method = RequestMethod.POST)
    public String createTourParticipant(Model model,
           @ModelAttribute("tourParticipantsForm") TourParticipantsForm tourParticipantsForm) {
        TourParticipants tourParticipants = new TourParticipants();
    tourParticipants.setId(tourParticipantsForm.getId());
    /*
    Participants participants = participantService.get(tourParticipantsForm.getParticipant());
    tourParticipants.setParticipant(participants);
    */
    tourParticipants.setParticipant(tourParticipantsForm.getParticipant());
    /*
    Tours tour = tourService.get(tourParticipantsForm.getTour());
    tourParticipants.setTour(tour);
    */
    tourParticipants.setTour(tourParticipantsForm.getTour());
        tourParticipants.setCost(tourParticipantsForm.getCost());
        tourParticipants.setPermission(tourParticipantsForm.isPermission());
        tourParticipantService.create(tourParticipants);
        model.addAttribute("tourParticipants", tourParticipantService.getAll());
        return "redirect:/tourparticipants";
}

    @RequestMapping(value = "/create-tour", method = RequestMethod.GET)
    public String createTour(Model model) {
        ToursForm toursForm = new ToursForm();
        model.addAttribute("toursForm", toursForm);
        return "create-tour";
    }

@RequestMapping(value = "/create-tour", method = RequestMethod.POST)
    public String createTour(Model model,
           @ModelAttribute("toursForm") ToursForm toursForm) {
        Tours tours = new Tours();
        tours.setId(toursForm.getId());
        tours.setTourTyp(toursForm.getTourTyp());
        tours.setStartDate(toursForm.getStartDate());
        tourService.create(tours);
        model.addAttribute("tours", tourService.getAll());
        return "redirect:/create-tour";
    }

@RequestMapping(value = "/reloadDB", method = RequestMethod.GET)
    String refreshParticipants() {
        participantService.reloadData();
        return "redirect:/participants";
    }

}
