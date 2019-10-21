package by.bsu.zmicier.dto;

import by.bsu.zmicier.utils.NotNullUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Game implements Serializable {
    private List<Tour> gameStructure;
    private Map<Integer, String> players;

    private Map<Integer, Map<Integer, Integer>> points; // tourId: [teamId: points]

    public Game() {
    }

    public Game(List<Tour> gameStructure, Map<Integer, String> players) {
        this.gameStructure = gameStructure;
        this.players = players;
    }

    public List<Tour> getGameStructure() {
        return NotNullUtils.getList(gameStructure);
    }

    public void setGameStructure(List<Tour> gameStructure) {
        this.gameStructure = gameStructure;
    }

    public Map<Integer, String> getPlayers() {
        return NotNullUtils.getMap(players);
    }

    public void setPlayers(Map<Integer, String> players) {
        this.players = players;
    }

    public Map<Integer, Map<Integer, Integer>> getPoints() {
        return NotNullUtils.getMap(points);
    }

    public void setPoints(Map<Integer, Map<Integer, Integer>> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameStructure, game.gameStructure) &&
                Objects.equals(players, game.players) &&
                Objects.equals(points, game.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameStructure, players, points);
    }
}
