package com.example.cars.Publication.Follow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow,Integer> {
    List<Follow> findFollowByFollower(int id);
}
