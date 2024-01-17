package com.example.cars.Flag;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlagService {

    private final FlagsRepository repository;

    public Flag addFlag(Flag f){
        return this.repository.save(f);
    }

    public List<Flag> getFlags(){
        return this.repository.findAll();
    }

    public Flag deleteFlag(int i){

        Flag f  = repository.findById(i).get();
        this.repository.deleteById(i);
        return f;
    }

}
