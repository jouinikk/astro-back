package com.example.cars.Publication;

import com.example.cars.Publication.comments.Comment;
import com.example.cars.Publication.comments.CommentRepository;
import com.example.cars.Publication.comments.CommentRequest;
import com.example.cars.Publication.reacts.React;
import com.example.cars.Publication.reacts.ReactRepository;
import com.example.cars.Publication.reacts.ReactRequest;
import com.example.cars.user.User;
import com.example.cars.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationService {

    public final UserService userService;

    public final PublicationRepository publicationRepository;

    public final ReactRepository reactRepository;

    public final CommentRepository commentRepository;


    // publications
    public List<Publication> getPublication(){
        return publicationRepository.findAll();
    }

    public Publication getPublicationById(int id){
        return publicationRepository.findById(id).get();
    }

    public List<Publication> getByUserId(int userid){
        return publicationRepository.findByUserIdOrderByCreatedAt(userid);
    }

    public Publication AddPublication(Publication p ){
        return  publicationRepository.save(p);
    }

    public void deletePublication(int id){
        commentRepository.deleteAll(commentRepository.findCommentByPublicationidId(id));
        reactRepository.deleteAll(reactRepository.findReactByPublicationidId(id));
        Publication p = getPublicationById(id);
        publicationRepository.delete(p);
    }

    //reacts
    public React like(ReactRequest l){
        User u = userService.getUserById(l.getUserId());
        Publication publication = getPublicationById(l.getPubId());
        React r = new React();
        r.setUserid(u);
        r.setPublicationid(publication);
        return reactRepository.save(r);
    }

    public List<React> getReactsByPublicationid(int i)
    {
        Publication p = publicationRepository.findById(i).get();
        return reactRepository.findReactByPublicationid(p);
    }

    public void deleteReact(int userId,int pubId){
        List<React> r = reactRepository.findReactByPublicationidIdAndUseridId(pubId,userId);
        System.out.println(r.toString());
        reactRepository.deleteAllInBatch(r);
    }

    //comment
    public Comment comment(CommentRequest c){
        Comment theComment = new Comment();
        User u = userService.getUserById(c.getUserId());
        Publication p = getPublicationById(c.getPubId());
        theComment.setPublicationid(p);
        theComment.setUserid(u);
        theComment.setContent(c.getContent());
        return commentRepository.save(theComment);
    }

    public List<Comment> getCommentsByPostId(int id){
        return commentRepository.findCommentByPublicationidId(id);
    }

    public void deleteComment(int id){
        commentRepository.deleteById(id);
    }

    public boolean checkLike(int userId,int pubId){
        boolean v = false;
        List<React> likes = reactRepository.findReactByUseridId(userId);
        for(React react:likes){
            if (react.getPublicationid().getId() == pubId) {
                v = true;
                break;
            }
        }
        return v;
    }
}
