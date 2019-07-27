package fr.orantoine.fortnitegenerationv2.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/status")
public class StatusController {

    @GetMapping(value = "")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.status(200).body("OK");
    }
}
