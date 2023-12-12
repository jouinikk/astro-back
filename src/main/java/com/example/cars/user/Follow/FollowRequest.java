package com.example.cars.user.Follow;

import com.example.cars.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowRequest {
    private User follower;
    private User following;
}
