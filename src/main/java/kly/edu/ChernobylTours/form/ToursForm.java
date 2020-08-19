package kly.edu.ChernobylTours.form;

import java.time.LocalDate;

public class ToursForm {

    private String id;
    private String tourTyp;
    private LocalDate startDate;

    public ToursForm(){}

    public ToursForm(String id, String tourTyp, LocalDate startDate) {
        this.id = id;
        this.tourTyp = tourTyp;
        this.startDate = startDate;
    }

    public ToursForm(String tourTyp, LocalDate startDate) {
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
