package sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class SampleController {

    @GetMapping("private")
    public String sample() {
        return "private " + LocalDateTime.now();
    }

}
