package one.digitalinnovation.gof.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "🚀 Spring Boot funcionando no WSL2 + IntelliJ IDEA!";
    }

}

