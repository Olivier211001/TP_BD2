package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "spring.sql.init.mode=never",
        "spring.jpa.hibernate.ddl-auto=create-drop" })
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private com.example.library.service.LivreService livreService;

    @Test
    void livrelEndpoint_isAvailable() {
        when(livreService.findAll()).thenReturn(List.of());
        ResponseEntity<String> resp = restTemplate.getForEntity("/api/livres", String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
