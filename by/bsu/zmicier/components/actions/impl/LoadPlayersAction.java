package by.bsu.zmicier.components.actions.impl;

import by.bsu.zmicier.components.Request;
import by.bsu.zmicier.components.RequestRules;
import by.bsu.zmicier.components.actions.AbstractAction;
import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.impl.StartQuizMessage;
import by.bsu.zmicier.dto.GameState;

import java.util.*;

public class LoadPlayersAction extends AbstractAction {
    @Override
    public Message execute(Request request, GameState gameState) {
        String[] playersName = (String[]) request.getAttribute(RequestRules.PLAYERS_NAME);
        Boolean shuffle = (Boolean) request.getAttribute(RequestRules.SHUFFLE_PLAYERS);

        List<String> playersAsList = new ArrayList<>(Arrays.asList(playersName));

        if(shuffle) {
            Collections.shuffle(playersAsList);
        }
        Map<Integer, String> playersAsMap = new HashMap<>();
        for(int i = 0; i < playersAsList.size(); i++) {
            playersAsMap.put(i, playersAsList.get(i));
        }
        gameState.getGame().setPlayers(playersAsMap);
        StartQuizMessage message = new StartQuizMessage();
        message.setGameDescription(gameState.getGame());

        return message;
    }
}
