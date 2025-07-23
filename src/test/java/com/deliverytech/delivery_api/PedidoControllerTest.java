import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoControllerTest {

    private final String BASE_URL = "http://localhost:8080/api/pedidos/1/status";

    @Test
    public void testPatchStatus() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        
        String jsonBody = "{\"status\": \"CONFIRMADO\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.PATCH, requestEntity, String.class);
        
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("{\"status\":\"CONFIRMADO\"}", response.getBody());
    }
}