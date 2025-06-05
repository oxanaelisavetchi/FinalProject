package com.automation.project.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> contextData = new HashMap<>();

    public void set(String key, Object value) {
        contextData.put(key, value);
    }

    public <T> T get(String key) {
        return (T) contextData.get(key);
    }

    public boolean contains(String key) {
        return contextData.containsKey(key);
    }
}
