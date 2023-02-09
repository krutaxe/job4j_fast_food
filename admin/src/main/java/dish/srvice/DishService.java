package dish.srvice;

import lombok.AllArgsConstructor;
import model.Dish;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DishService {
    private static final String URL = "http://localhost:8080/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Dish findById(int id) {
        return restTemplate.getForObject(URL +  id, Dish.class);
    }

    public void add(Dish dish) {
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", dish.getName());
        jsonToSend.put("priceDish", String.valueOf(dish.getPriceDish()));

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        restTemplate.postForObject(URL, request, Dish.class);
    }

    public List<Dish> findAll() {
        ResponseEntity<List<Dish>> responseEntity = restTemplate.exchange(
                URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Dish>>() { });
        return responseEntity.getBody();
    }

    public void delete(int id) {
        restTemplate.delete(URL + "del/" +  id, HttpMethod.DELETE);
    }
}
