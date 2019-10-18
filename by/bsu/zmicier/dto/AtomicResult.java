package by.bsu.zmicier.dto;

import java.util.Objects;

public class AtomicResult {
    private double points;
    private Team team;

    public AtomicResult() {
    }

    public AtomicResult(Team team) {
        this.team = team;
    }

    public AtomicResult(double points, Team team) {
        this.points = points;
        this.team = team;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtomicResult that = (AtomicResult) o;
        return Double.compare(that.points, points) == 0 &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, team);
    }
}
