package kly.edu.ChernobylTours.datastorage;

import kly.edu.ChernobylTours.model.Participants;
import kly.edu.ChernobylTours.model.TourParticipants;
import kly.edu.ChernobylTours.model.Tours;
import kly.edu.ChernobylTours.repository.ParticipantsRepository;
import kly.edu.ChernobylTours.repository.TourParticipantsRepository;
import kly.edu.ChernobylTours.repository.ToursRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DataFake {

    @Autowired
    ParticipantsRepository participantsRepository;
    @Autowired
    ToursRepository toursRepository;
    @Autowired
    TourParticipantsRepository tourParticipantsRepository;

    private List<Participants> participantsList = new LinkedList<>(Arrays.asList(
        new Participants("id1","Ignat Epopejevitch","380787546321","ignat.epopej67@mail.su","KS156"),
        new Participants("id2","Kurales Bedakurov","380787546312","kurales97@mail.ru","KS156"),
        new Participants("id3","Dipi Schmot","380787546322","violator@bong.com","KS156")
    ));

    private List<Tours> toursList = new LinkedList<>(Arrays.asList(
            new Tours("05-10-1","one-day", LocalDate.of(2020, 5, 10)),
            new Tours("05-10-2","two-day", LocalDate.of(2020, 5, 10)),
            new Tours("05-11-1","one-day", LocalDate.of(2020, 5, 11)),
            new Tours("05-11-2","two-day", LocalDate.of(2020, 5, 11)),
            new Tours("05-12-1","one-day", LocalDate.of(2020, 5, 12)),
            new Tours("05-12-2","two-day", LocalDate.of(2020, 5, 12)),
            new Tours("05-13-1","one-day", LocalDate.of(2020, 5, 13)),
            new Tours("05-13-2","two-day", LocalDate.of(2020, 5, 13)),
            new Tours("05-14-1","one-day", LocalDate.of(2020, 5, 14)),
            new Tours("05-14-2","two-day", LocalDate.of(2020, 5, 14)),
            new Tours("05-15-1","one-day", LocalDate.of(2020, 5, 15)),
            new Tours("05-15-2","two-day", LocalDate.of(2020, 5, 15)),
            new Tours("05-16-1","one-day", LocalDate.of(2020, 5, 16)),
            new Tours("05-16-2","two-day", LocalDate.of(2020, 5, 16)),
            new Tours("05-17-1","one-day", LocalDate.of(2020, 5, 17)),
            new Tours("05-17-2","two-day", LocalDate.of(2020, 5, 17)),
            new Tours("05-18-1","one-day", LocalDate.of(2020, 5, 18)),
            new Tours("05-18-2","two-day", LocalDate.of(2020, 5, 18)),
            new Tours("05-19-1","one-day", LocalDate.of(2020, 5, 19)),
            new Tours("05-19-2","two-day", LocalDate.of(2020, 5, 19)),
            new Tours("05-20-1","one-day", LocalDate.of(2020, 5, 20)),
            new Tours("05-20-2","two-day", LocalDate.of(2020, 5, 20)),
            new Tours("05-21-1","one-day", LocalDate.of(2020, 5, 21)),
            new Tours("05-21-2","two-day", LocalDate.of(2020, 5, 21)),
            new Tours("05-22-1","one-day", LocalDate.of(2020, 5, 22)),
            new Tours("05-22-2","two-day", LocalDate.of(2020, 5, 22)),
            new Tours("05-23-1","one-day", LocalDate.of(2020, 5, 23)),
            new Tours("05-23-2","two-day", LocalDate.of(2020, 5, 23)),
            new Tours("05-24-1","one-day", LocalDate.of(2020, 5, 24)),
            new Tours("05-24-2","two-day", LocalDate.of(2020, 5, 24)),
            new Tours("05-25-1","one-day", LocalDate.of(2020, 5, 25)),
            new Tours("05-25-2","two-day", LocalDate.of(2020, 5, 25)),
            new Tours("05-26-1","one-day", LocalDate.of(2020, 5, 26)),
            new Tours("05-26-2","two-day", LocalDate.of(2020, 5, 26)),
            new Tours("05-27-1","one-day", LocalDate.of(2020, 5, 27)),
            new Tours("05-27-2","two-day", LocalDate.of(2020, 5, 27)),
            new Tours("05-28-1","one-day", LocalDate.of(2020, 5, 28)),
            new Tours("05-28-2","two-day", LocalDate.of(2020, 5, 28)),
            new Tours("05-29-1","one-day", LocalDate.of(2020, 5, 29)),
            new Tours("05-29-2","two-day", LocalDate.of(2020, 5, 29)),
            new Tours("05-30-1","one-day", LocalDate.of(2020, 5, 30)),
            new Tours("05-30-2","two-day", LocalDate.of(2020, 5, 30)),
            new Tours("05-31-1","one-day", LocalDate.of(2020, 5, 31)),
            new Tours("05-31-2","two-day", LocalDate.of(2020, 5, 31))
    ));

    private List<TourParticipants> tourParticipantsList = new LinkedList<>(Arrays.asList(
            new TourParticipants(participantsList.get(0), toursList.get(20), 1200, true),
            new TourParticipants(participantsList.get(1), toursList.get(10), 1500, false),
            new TourParticipants(participantsList.get(2), toursList.get(3), 900, true)
    ));

    public List<Participants> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(List<Participants> participantsList) {
        this.participantsList = participantsList;
    }

    public List<Tours> getToursList() {
        return toursList;
    }

    public void setToursList(List<Tours> toursList) {
        this.toursList = toursList;
    }

    public List<TourParticipants> getTourParticipantsList() {
        return tourParticipantsList;
    }

    public void setTourParticipantsList(List<TourParticipants> tourParticipantsList) {
        this.tourParticipantsList = tourParticipantsList;
    }

    //@PostConstruct
    /*private*/ public void init(){
        participantsRepository.deleteAll();
        participantsRepository.saveAll(participantsList);
        tourParticipantsRepository.deleteAll();
        tourParticipantsRepository.saveAll(tourParticipantsList);
        toursRepository.deleteAll();
        toursRepository.saveAll(toursList);

    }
}
