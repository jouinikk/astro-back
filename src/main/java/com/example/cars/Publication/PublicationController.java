package com.example.cars.Publication;

import com.example.cars.Flag.FlagsRepository;
import com.example.cars.Publication.comments.Comment;
import com.example.cars.Publication.comments.CommentRequest;
import com.example.cars.Publication.reacts.React;
import com.example.cars.Publication.reacts.ReactRequest;
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
    private final FlagsRepository flagsRepository;
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
    public ResponseEntity<React> like(@RequestBody ReactRequest l){
        return ResponseEntity.ok(service.like(l));
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> comment(@RequestBody CommentRequest c){
        return ResponseEntity.ok(service.comment(c));
    }

    @GetMapping("/comment/{id}")
    public List<Comment> commentsByPost(@PathVariable int id){
        return service.getCommentsByPostId(id);
    }

    @GetMapping("/like/{id}")
    public List<React> likesByPost(@PathVariable int id){
        return service.getReactsByPublicationid(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.deletePublication(id);
    }

    @GetMapping("/hasLikes/{userid}/{pubid}")
    public ResponseEntity<Boolean> hasLikes (@PathVariable int userid,@PathVariable int pubid){
        return ResponseEntity.ok(service.checkLike(userid,pubid));
    }

    @DeleteMapping("/unlike/{user}/{pub}")
    public void unlike(@PathVariable int user,@PathVariable int pub){
        service.deleteReact(user,pub);
    }
}
