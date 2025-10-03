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
        // For now, just echo back the empty JSON
        return ResponseEntity.ok(body);
    }
}
