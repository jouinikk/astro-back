package com.example.cars.user.Follow;

import com.example.cars.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow,Integer> {
    List<Follow> findFollowByFollower(User u);
    List<Follow> findFollowByFollowing(User u);
    List<Follow>findFollowByFollowerAndFollowing(User follower,User following);
}
