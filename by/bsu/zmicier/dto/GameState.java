package by.bsu.zmicier.dto;

import java.io.Serializable;

public class GameState implements Serializable {
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void copyState(GameState that) {
        this.game = that.game;
    }
}
