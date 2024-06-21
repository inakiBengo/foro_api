package controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/topicos")
public class ControllerTopicos {

    @PostMapping
    public ResponseEntity postTopico(@RequestBody @Valid ) {

    }
}
