package com.example.cars.user;

import com.example.cars.user.Follow.Follow;
import com.example.cars.user.Follow.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public List<User> users(){
        return userRepository.findAll();
    }

    public User getUserById(int id) throws NoSuchElementException {
        return userRepository.findById(id).get();
    }

    public List<User> getUser(String first, String last) {
        return userRepository.findUsersByFirstNameAndLastName(first,last);
    }

    public List<User> getLockedUsers(){
        List<User> users = users();
        List<User> lockedUsers = new ArrayList<>();

        for(User u:users){
           if(u.isLocked()) lockedUsers.add(u);
        }
        return lockedUsers;
    }

    public List<User> getUnlockedUsers(){
        List<User> users = users();
        List<User> unlockedUsers = new ArrayList<>();

        for(User u:users){
            if(!u.isLocked()) unlockedUsers.add(u);
        }
        return unlockedUsers;
    }

    public Follow follow(User follower,User following){
        Follow follow = new Follow(follower,following);
        return followRepository.save(follow);
    }

    public void unFollow(int follower,int following){
        User theFollower = userRepository.findById(follower).get();
        User theFollowing = userRepository.findById(following).get();
        List<Follow> follows= followRepository.findFollowByFollowerAndFollowing(theFollower,theFollowing);
        followRepository.deleteAll(follows);
    }

    public boolean checkFollow(User follower,User user){
        List<User> followings  = getfollowing(follower.getId());
        return followings.contains(user);
    }

    public List<User> getUsersByName(String first, String last) {
        return userRepository.findUsersByFirstNameAndLastName(first,last);
    }

    public User lockAccount(int i){
        User user = userRepository.findById(i).get();
        user.setLocked(true);
        return userRepository.save(user);
    }

    public List<User> getfollowing(int id) {
        User u = userRepository.findById(id).get();
        List<Follow> follows = followRepository.findFollowByFollower(u);
        List<User> users = new ArrayList<>();
        for(Follow follow:follows){
            users.add(follow.getFollowing());
        }
        return users;
    }
    public List<User> getFollowers(int id){
        User u = userRepository.findById(id).get();
        List<Follow> follows = followRepository.findFollowByFollowing(u);
        List<User> users = new ArrayList<>();
        for (Follow follow:follows){
            users.add(follow.getFollower());
        }
        return users;
    }

    public List<User> explore(int id){
        User theUser = userRepository.findById(id).get();
        List<User> users = users();
        List<User> followings = this.getfollowing(id);
        List<User> news = new ArrayList<>();
        for(User user:users){
            if(!followings.contains(user) && !(theUser.getId()==user.getId())){
                news.add(user);
            }
        }
        return news;
    }

    public User unlockAccount(int id) {
        User user = userRepository.findById(id).get();
        user.setLocked(false);
        return userRepository.save(user);
    }
}
