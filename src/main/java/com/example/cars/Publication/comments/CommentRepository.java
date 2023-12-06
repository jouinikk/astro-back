package com.example.cars.Publication.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Override
    <S extends Comment> S save(S entity);


    List<Comment> findCommentByPublicationidId(int id);
}