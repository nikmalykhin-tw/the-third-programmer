package com.kata.hierarchy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HierarchyController {
    @PostMapping("/hierarchy")
    public ResponseEntity<Map<String, HierarchyNode>> postHierarchy(@RequestBody Map<String, Object> body) {
        Map<String, HierarchyNode> result = buildHierarchy(body);
        return ResponseEntity.ok(result);
    }

    private Map<String, HierarchyNode> buildHierarchy(Map<String, Object> input) {
        if (input == null || input.isEmpty()) {
            return Map.of();
        }
        Map<String, String> childToParent = new java.util.HashMap<>();
        for (Map.Entry<String, Object> entry : input.entrySet()) {
            String child = entry.getKey();
            Object parentObj = entry.getValue();
            String parent = parentObj == null ? null : parentObj.toString();
            childToParent.put(child, parent);
        }
        java.util.Set<String> allPeople = new java.util.HashSet<>(childToParent.keySet());
        for (String parent : childToParent.values()) {
            if (parent != null) {
                allPeople.add(parent);
            }
        }
        java.util.Set<String> children = new java.util.HashSet<>(childToParent.keySet());
        java.util.Set<String> roots = new java.util.HashSet<>();
        for (Map.Entry<String, String> entry : childToParent.entrySet()) {
            if (entry.getValue() == null) {
                roots.add(entry.getKey());
            }
        }
        for (String person : allPeople) {
            if (!children.contains(person)) {
                roots.add(person);
            }
        }
        // Build tree using HierarchyNode
        java.util.Map<String, HierarchyNode> nodeMap = new java.util.HashMap<>();
        for (String person : allPeople) {
            nodeMap.put(person, new HierarchyNode());
        }
        for (Map.Entry<String, String> entry : childToParent.entrySet()) {
            String child = entry.getKey();
            String parent = entry.getValue();
            if (parent != null) {
                nodeMap.get(parent).addChild(child, nodeMap.get(child));
            }
        }
        java.util.Map<String, HierarchyNode> result = new java.util.HashMap<>();
        for (String root : roots) {
            result.put(root, nodeMap.get(root));
        }
        return result;
    }
}
