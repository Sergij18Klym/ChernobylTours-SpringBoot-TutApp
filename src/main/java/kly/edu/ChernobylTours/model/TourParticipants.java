package kly.edu.ChernobylTours.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TourParticipants {
@Id
    private String id;
    private Participants participant;
    private Tours tour;
    private double cost;
    private boolean permission;


    public TourParticipants(){}

    public TourParticipants(String id, Participants participant, Tours tour, double cost, boolean permission) {
        this.id = id;
        this.participant = participant;
        this.tour = tour;
        this.cost = cost;
        this.permission = permission;
    }

    public TourParticipants(Participants participant, Tours tour, double cost, boolean permission) {
        this.participant = participant;
        this.tour = tour;
        this.cost = cost;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Participants getParticipant() {
        return participant;
    }

    public void setParticipant(Participants participant) {
        this.participant = participant;
    }

    public Tours getTour() {
        return tour;
    }

    public void setTour(Tours tour) {
        this.tour = tour;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
