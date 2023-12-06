package com.example.cars.Publication.comments;

import com.example.cars.Publication.Publication;
import com.example.cars.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

    @ManyToOne
    @JoinColumn(name = "publicationid")
    private Publication publicationid;

    private String content;
}
