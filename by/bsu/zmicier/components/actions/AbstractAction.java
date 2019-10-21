package by.bsu.zmicier.components.actions;

import by.bsu.zmicier.components.Request;
import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.dto.GameState;

public abstract class AbstractAction {
    public abstract Message execute(Request request, GameState gameState);
}
