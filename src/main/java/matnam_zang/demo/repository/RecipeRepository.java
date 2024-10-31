package matnam_zang.demo.repository;

import matnam_zang.demo.dto.CookRcpResponseDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RecipeRepository {
    private final RestTemplate restTemplate;
    private static final String API_URL = "http://openapi.foodsafetykorea.go.kr/api/5a4532257f514de99381/COOKRCP01/json/1/5";

    public RecipeRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CookRcpResponseDto getRecipes() {
        return restTemplate.getForObject(API_URL, CookRcpResponseDto.class);
    }
}


