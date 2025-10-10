package com.kata.hierarchy;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

public class HierarchyNode {
    private final Map<String, HierarchyNode> children = new HashMap<>();

    public Map<String, HierarchyNode> getChildren() {
        return children;
    }

    public void addChild(String name, HierarchyNode node) {
        children.put(name, node);
    }

    @JsonValue
    public Map<String, HierarchyNode> asMap() {
        return children;
    }
}
