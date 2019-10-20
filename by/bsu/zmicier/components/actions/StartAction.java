package by.bsu.zmicier.components.actions;

import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.StartMessage;
import by.bsu.zmicier.schemas.AllSchemas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StartAction extends AbstractAction{

    @Override
    public Message execute() {
        StartMessage message = new StartMessage();

        message.setAvailableSchemas(Arrays.stream(AllSchemas.values()).collect(Collectors.toMap(AllSchemas::name, AllSchemas::getDescription)));

        return message;
    }
}
