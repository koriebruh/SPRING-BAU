package koriebruh.dev.bau.controller;


import koriebruh.dev.bau.dto.HelloResponse;
import koriebruh.dev.bau.entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> hello() {
        Admin admin = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HelloResponse response = new HelloResponse(
                "Hello World from user: " + admin.getUsername(),
                admin.getId()
        );
        return ResponseEntity.ok(response);
    }
}
