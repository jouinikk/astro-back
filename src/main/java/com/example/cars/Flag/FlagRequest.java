package com.example.cars.Flag;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlagRequest {
    int userId;
    int publicationId;
    String text;
}
