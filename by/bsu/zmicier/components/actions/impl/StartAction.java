package by.bsu.zmicier.components.actions.impl;

import by.bsu.zmicier.components.Request;
import by.bsu.zmicier.components.actions.AbstractAction;
import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.Pages;
import by.bsu.zmicier.components.messages.impl.StartMessage;
import by.bsu.zmicier.dto.GameState;

public class StartAction extends AbstractAction {

    @Override
    public Message execute(Request request, GameState gameState) {
        return new StartMessage();
    }
}
