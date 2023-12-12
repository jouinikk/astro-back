package com.example.cars.user.Follow;

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
public class Follow {

    public Follow(User follower,User following){
        this.follower=follower;
        this.following=following;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private User following;
}
