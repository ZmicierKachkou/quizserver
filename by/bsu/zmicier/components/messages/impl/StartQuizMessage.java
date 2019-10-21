package by.bsu.zmicier.components.messages.impl;

import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.Pages;
import by.bsu.zmicier.dto.Game;

public class StartQuizMessage extends Message {
    private final static String GAME_DESCRIPTION = "game_description";

    public StartQuizMessage() {
        super(Pages.QUIZ_MAIN_SCREEN);
    }

    public Game getGameDescription() {
        return (Game) getAttribute(GAME_DESCRIPTION);
    }

    public void setGameDescription(Game gameDescription) {
        addAttribute(GAME_DESCRIPTION, gameDescription);
    }
}
