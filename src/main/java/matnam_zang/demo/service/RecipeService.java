package matnam_zang.demo.service;

import matnam_zang.demo.dto.CookRcpResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeService {
    private final RestTemplate restTemplate;

    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CookRcpResponseDto getRecipes() {
        String apiUrl = "http://openapi.foodsafetykorea.go.kr/api/5a4532257f514de99381/COOKRCP01/json/1/5";
        log.info(apiUrl);
        try {
            log.info(apiUrl);
            return restTemplate.getForObject(apiUrl, CookRcpResponseDto.class);
        } catch (Exception e) {
            e.printStackTrace(); // 오류 로그 출력
            return null; // 오류 발생 시 null 반환
        }
    }
}


