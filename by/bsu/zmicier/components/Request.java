package by.bsu.zmicier.components;

import by.bsu.zmicier.utils.NotNullUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String action;
    private final Map<String, Object> attributes = new HashMap<>();

    boolean validateAttribute(String attrName) {
        Class<?> requestRulesClazz = RequestRules.class;
        try {
            Field field = requestRulesClazz.getField(attrName);
            Field field_class = requestRulesClazz.getField(attrName + "_CLASS_CHECK");
            Class<?> expectedClazz = (Class) field_class.get(null);

            return expectedClazz.isInstance(getAttribute(attrName));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    public Request(String action) {
        this.action = action;
    }

    public Request(String action, Map<String, String> attributes) {
        this.action = action;
        this.attributes.putAll(attributes);
    }

    public String getAction() {
        return action;
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}
