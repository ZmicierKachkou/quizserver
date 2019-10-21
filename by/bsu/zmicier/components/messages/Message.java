package by.bsu.zmicier.components.messages;

import by.bsu.zmicier.utils.NotNullUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class Message {
    protected final Map<String, Object> attributes = new HashMap<>();
    protected final String page;

    public Message(String page) {
        this.page = page;
    }

    public Object getAttribute(String name) {
        return NotNullUtils.getMap(attributes).get(name);
    }

    protected void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }
}
