package by.bsu.zmicier.components.messages.impl;

import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.components.messages.Pages;

public class StartMessage extends Message {
    private final static String ERROR_NOTIFICATION = "error_notification";

    public StartMessage() {
        super(Pages.START);
    }

    public void setErrorNotification(String notification) {
        addAttribute(ERROR_NOTIFICATION, notification);
    }

    public String getErrorNotification() {
        return (String) getAttribute(ERROR_NOTIFICATION);
    }

}
