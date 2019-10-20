package by.bsu.zmicier.components.messages;

import java.util.Map;

public class StartMessage extends Message {
    private Map<String, String> availableSchemas;

    public Map<String, String> getAvailableSchemas() {
        return availableSchemas;
    }

    public void setAvailableSchemas(Map<String, String> availableSchemas) {
        this.availableSchemas = availableSchemas;
    }
}
