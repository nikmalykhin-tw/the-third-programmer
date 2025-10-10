package com.kata.hierarchy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HierarchyController {
    @PostMapping("/hierarchy")
    public ResponseEntity<Map<String, Object>> postHierarchy(@RequestBody Map<String, Object> body) {
        // Transform the input into the required hierarchy structure
        Map<String, Object> result = buildHierarchy(body);
        return ResponseEntity.ok(result);
    }

    private Map<String, Object> buildHierarchy(Map<String, Object> input) {
        // If input is empty, return empty map
        if (input == null || input.isEmpty()) {
            return Map.of();
        }
        // Step 1: Build child->parent map
        Map<String, String> childToParent = new java.util.HashMap<>();
        for (Map.Entry<String, Object> entry : input.entrySet()) {
            String child = entry.getKey();
            Object parentObj = entry.getValue();
            String parent = parentObj == null ? null : parentObj.toString();
            childToParent.put(child, parent);
        }
        // Step 2: Find all people and all children
        java.util.Set<String> allPeople = new java.util.HashSet<>(childToParent.keySet());
        for (String parent : childToParent.values()) {
            if (parent != null) {
                allPeople.add(parent);
            }
        }
        java.util.Set<String> children = new java.util.HashSet<>(childToParent.keySet());
        // Step 3: Roots are those who are not anyone's child, or whose parent is null
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
        // Step 4: Build tree
        java.util.Map<String, java.util.Map<String, Object>> tree = new java.util.HashMap<>();
        for (String person : allPeople) {
            tree.put(person, new java.util.HashMap<>());
        }
        for (Map.Entry<String, String> entry : childToParent.entrySet()) {
            String child = entry.getKey();
            String parent = entry.getValue();
            if (parent != null) {
                tree.get(parent).put(child, tree.get(child));
            }
        }
        // Step 5: Return only the root(s)
        java.util.Map<String, Object> result = new java.util.HashMap<>();
        for (String root : roots) {
            result.put(root, tree.get(root));
        }
        return result;
    }
}
