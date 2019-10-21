package by.bsu.zmicier.components.actions;

import by.bsu.zmicier.components.actions.impl.LoadGameInProgessAction;
import by.bsu.zmicier.components.actions.impl.StartAction;

import java.util.HashMap;
import java.util.Map;

public final class ActionMapping {
    private ActionMapping() {}

    private final static Map<String, AbstractAction> MAPPING = new HashMap<>();

    static {
        MAPPING.put("start", new StartAction());
        MAPPING.put("load_game_in_progress", new LoadGameInProgessAction());
    }

    public static AbstractAction getAction(String actionName) {
        return MAPPING.get(actionName);
    }
}
