package br.com.hirao.ci.github.helloworldcigithub.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class HelloController {
    private final String env;

    public HelloController(@Value("${helloworld.env}") String env) {
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from container");
    }

    @GetMapping("env")
    public ResponseEntity<String> helloEnv() {
        return ResponseEntity.ok(env);
    }
}
