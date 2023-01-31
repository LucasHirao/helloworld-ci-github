package br.com.hirao.ci.github.helloworldcigithub.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class HelloControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort 
    private Integer port;

    @Test
    void testHello() {
        var resultado = testRestTemplate.getForObject("http://localhost:" + port+ "/", String.class);
        assertEquals("Hello from container", resultado);
    }

    @Test
    void testEnv() {
        var resultado = testRestTemplate.getForObject("http://localhost:" + port+ "/env", String.class);
        assertEquals("test", resultado);
    }
}
