package by.bsu.zmicier.dto;

import by.bsu.zmicier.utils.NotNullUtils;

import java.util.List;
import java.util.Objects;

public class Team {
    private int id;
    private String name;
    private List<Player> players;

    public Team() {
    }

    public Team(int id, String name, List<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return NotNullUtils.getString(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return NotNullUtils.getList(players);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
