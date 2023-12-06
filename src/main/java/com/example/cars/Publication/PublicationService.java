package com.example.cars.Publication;

import com.example.cars.Publication.comments.Comment;
import com.example.cars.Publication.comments.CommentRepository;
import com.example.cars.Publication.reacts.React;
import com.example.cars.Publication.reacts.ReactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationService {

    public final PublicationRepository publicationRepository;

    public final ReactRepository reactRepository;

    public final CommentRepository commentRepository;


    // publications
    public List<Publication> getPublication(){
        return publicationRepository.findAll();
    }

    public List<Publication> getByUserId(int userid){
        return publicationRepository.findByUserId(userid);
    }

    public Publication AddPublication(Publication p ){
        return  publicationRepository.save(p);
    }

    public void deletePublication(int id){
        publicationRepository.deleteById(id);
    }

    //reacts
    public React like(React l){
        return reactRepository.save(l);
    }

    public List<React> getReactsByPublication(int id){
        return reactRepository.findReactByPublicationid(id);
    }

    public void deleteReact(int id){
        reactRepository.deleteById(id);
    }
    //comment

    public Comment comment(Comment c){
        return commentRepository.save(c);
    }

    public List<Comment> getCommentsByPostId(int id){
        return commentRepository.findCommentByPublicationidId(id);
    }


}
