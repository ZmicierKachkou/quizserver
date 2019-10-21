package by.bsu.zmicier.dto;

import by.bsu.zmicier.utils.NotNullUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Tour implements Serializable {
    private int tourId;
    private String tourName;
    private String tourDescription;

    private List<String> questions;
    private List<Team> teams;

    public Tour() {
    }

    public Tour(int tourId, String tourName, String tourDescription, List<String> questions, List<Team> teams) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.questions = questions;
        this.teams = teams;
    }

    public Tour(int tourId) {
        this.tourId = tourId;
    }

    public Tour(int tourId, String tourName, String tourDescription) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return NotNullUtils.getString(tourName);
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return NotNullUtils.getString(tourDescription);
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public List<String> getQuestions() {
        return NotNullUtils.getList(questions);
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<Team> getTeams() {
        return NotNullUtils.getList(teams);
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourId == tour.tourId &&
                Objects.equals(tourName, tour.tourName) &&
                Objects.equals(tourDescription, tour.tourDescription) &&
                Objects.equals(questions, tour.questions) &&
                Objects.equals(teams, tour.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, tourName, tourDescription, questions, teams);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourName='" + tourName + '\'' +
                ", tourDescription='" + tourDescription + '\'' +
                ", questions=" + questions +
                ", teams=" + teams +
                '}';
    }
}
