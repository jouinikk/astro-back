package com.example.cars.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public List<User> users(){
        return service.users();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById( @PathVariable int id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/user/name/{first}/{last}")
    public List<User> getUserByName(@PathVariable String first,@PathVariable String last){
        return service.getUserByName(first,last);
    }
}
