package com.example.cars.Publication.reacts;

import com.example.cars.Publication.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactRepository extends JpaRepository<React,Integer> {

    List<React> findReactByPublicationid(Publication p);
    List<React> findReactByPublicationidId(int id);
    List<React> findReactByUseridId(int id);
    List<React> findReactByPublicationidIdAndUseridId(int pub,int user);
}
