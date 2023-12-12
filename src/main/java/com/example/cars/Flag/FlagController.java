package com.example.cars.Flag;


import com.example.cars.Publication.Publication;
import com.example.cars.Publication.PublicationService;
import com.example.cars.user.User;
import com.example.cars.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flags")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class FlagController {

    private final  FlagService service;
    private final UserService userService;
    private final PublicationService publicationService;

    @GetMapping
    public List<Flag> getFlags(){
        return service.getFlags();
    }

    @PostMapping(path = "/addFlag")
    public Flag addFlag(@RequestBody FlagRequest flag){
        Flag f = new Flag();
        f.setText(flag.getText());

        User u = userService.getUserById(flag.getUserId());
        f.setUser(u);

        Publication p = publicationService.getPublicationById(flag.getPublicationId());
        f.setPublication(p);
        return service.addFlag(f);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Flag> deleteFlag(@PathVariable int id){
        return ResponseEntity.ok(service.deleteFlag(id));
    }
}
