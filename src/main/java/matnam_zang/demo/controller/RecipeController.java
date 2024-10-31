package matnam_zang.demo.controller;

import matnam_zang.demo.dto.CookRcpResponseDto;
import matnam_zang.demo.service.RecipeService;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class RecipeController {
    private final RestTemplate restTemplate;

    public RecipeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/recipes")
    public List<Map<String, Object>> getPosts() {
        String apiUrl = "http://openapi.foodsafetykorea.go.kr/api/5a4532257f514de99381/COOKRCP01/json/1/5";
        List<Map<String, Object>> posts = restTemplate.getForObject(apiUrl, List.class);
        return posts;
        // String response = recipeService.getRecipes();
        // if (response != null) {
        //     return ResponseEntity.ok(response);
        // } else {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        // }
    }
}


