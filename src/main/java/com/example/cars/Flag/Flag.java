package com.example.cars.Flag;

import com.example.cars.Publication.Publication;
import com.example.cars.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@RequiredArgsConstructor
@Table
@Getter
@Setter
public class Flag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @CreationTimestamp
    private Date createdAt ;

    private String text;
}
