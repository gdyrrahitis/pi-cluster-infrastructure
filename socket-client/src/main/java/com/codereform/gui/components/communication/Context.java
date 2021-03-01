package com.codereform.gui.components.communication;

import java.util.HashMap;
import java.util.List;

public class Context {
    private String data;
    private HashMap<String, Object> metadata;

    public Context(String data) {
        this.data = data;
        this.metadata = new HashMap<>();
    }

    public Context(String data, HashMap<String, Object> metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    public String getData() {
        return data;
    }

    public Object getMetadataValueByKey(String key) {
        return metadata.get(key);
    }

    public boolean containsKey(String key) {
        return metadata.containsKey(key);
    }
}
