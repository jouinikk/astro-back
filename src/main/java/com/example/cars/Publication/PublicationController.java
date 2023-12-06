package com.example.cars.Publication;

import com.example.cars.Publication.comments.Comment;
import com.example.cars.Publication.reacts.React;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/publication")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class PublicationController {

    private final PublicationService service;

    @GetMapping
    public List<Publication> publications(){
        return service.getPublication();
    }

    @GetMapping(path = "/user/{id}")
    public List<Publication> getByUserId(@PathVariable int id){
        return service.getByUserId(id);
    }

    @PostMapping("/addpub")
    public ResponseEntity<Publication> addPublication(@RequestBody Publication p){
        return ResponseEntity.ok(service.AddPublication(p));
    }

    @PostMapping("/like")
    public ResponseEntity<React> like(@RequestBody React l){
        return ResponseEntity.ok(service.like(l));
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> comment(@RequestBody Comment c){
        return ResponseEntity.ok(service.comment(c));
    }

    @GetMapping("/comment/{id}")
    public List<Comment> commentsByPost(@PathVariable int id){
        return service.getCommentsByPostId(id);
    }
}
