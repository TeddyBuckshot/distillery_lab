package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> filterWhiskyByYear (@RequestParam(name = "year", required = false) String year){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(2018), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/whiskies1")
    public ResponseEntity<List<Whisky>> filterWhiskyByAgeAndDistilleryName (@RequestParam(name = "age") int age, @RequestParam(name = "distilleryName") String distilleryName){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, distilleryName), HttpStatus.OK);
    }

}
