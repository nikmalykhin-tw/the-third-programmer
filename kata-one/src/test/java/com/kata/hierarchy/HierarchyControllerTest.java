package com.kata.hierarchy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HierarchyController.class)
class HierarchyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("POST /hierarchy with empty JSON returns empty JSON")
    void postEmptyJsonReturnsEmptyJson() throws Exception {
        mockMvc.perform(post("/hierarchy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    @DisplayName("POST /hierarchy with {\"Pete\": null} returns {\"Pete\": {}}")
    void postPeteNullReturnsPeteEmptyObject() throws Exception {
        mockMvc.perform(post("/hierarchy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"Pete\": null}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Pete\":{}}"));
    }

    @Test
    @DisplayName("POST /hierarchy with {\"Pete\": \"Nick\"} returns {\"Nick\": {\"Pete\": {}}}")
    void postPeteNickReturnsNickPeteHierarchy() throws Exception {
        mockMvc.perform(post("/hierarchy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"Pete\": \"Nick\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Nick\": {\"Pete\": {}}}"));
    }
}
