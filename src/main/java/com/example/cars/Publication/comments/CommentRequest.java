package com.example.cars.Publication.comments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private int userId;
    private int pubId;
    private String content;
}
