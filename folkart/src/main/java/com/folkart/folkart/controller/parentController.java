package com.folkart.folkart.controller;

import com.folkart.folkart.model.parents;
import com.folkart.folkart.repository.parentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class parentController {
    @Autowired
    private parentRepository parentRepository;

    @GetMapping("/parents")
      public List<parents>getAllParents(){return parentRepository.findAll();}



}
