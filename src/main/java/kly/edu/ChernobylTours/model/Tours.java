package kly.edu.ChernobylTours.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document
public class Tours {
@Id
    private String id;
    private String tourTyp;
    private LocalDate startDate;

    public Tours(){}

    public Tours(String id, String tourTyp, LocalDate startDate) {
        this.id = id;
        this.tourTyp = tourTyp;
        this.startDate = startDate;
    }

    public Tours(String tourTyp, LocalDate startDate) {
        this.tourTyp = tourTyp;
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String idTour) {
        this.id = id;
    }

    public String getTourTyp() {
        return tourTyp;
    }

    public void setTourTyp(String tourTyp) {
        this.tourTyp = tourTyp;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
