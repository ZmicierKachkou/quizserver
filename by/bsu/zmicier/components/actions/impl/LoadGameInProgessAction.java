package by.bsu.zmicier.components.actions.impl;

import by.bsu.zmicier.components.Request;
import by.bsu.zmicier.components.RequestRules;
import by.bsu.zmicier.components.actions.AbstractAction;
import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.Pages;
import by.bsu.zmicier.components.messages.impl.ContinueMessage;
import by.bsu.zmicier.components.messages.impl.StartMessage;
import by.bsu.zmicier.dto.GameState;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGameInProgessAction extends AbstractAction {
    @Override
    public Message execute(Request request, GameState gameState) {
        File file = (File) request.getAttribute(RequestRules.FILE_NAME);
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            GameState loadedGameState = (GameState) oi.readObject();
            gameState.copyState(loadedGameState);

            return new ContinueMessage();
        } catch(IOException | ClassNotFoundException e) {
            StartMessage message = new StartMessage();
            message.setErrorNotification("Cannot load a file!");
            return message;
        }
    }
}
