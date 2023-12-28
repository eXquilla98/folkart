package com.folkart.folkart.controller;

import com.folkart.folkart.model.parents;

import com.folkart.folkart.repository.parentRepository;
import com.folkart.folkart.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class parentController {
    @Autowired
    private parentRepository parentRepository;
    @Autowired
    private studentRepository studentRepository;

    //get parent using parentID
    @GetMapping("/parents")
      public List<parents>getAllParents(){return parentRepository.findAll();}

    //creting new parent
    @PostMapping("/parent")
    public ResponseEntity<parents> createParent(@RequestBody parents parents){
        parents saveParents = parentRepository.save(parents);
        return new ResponseEntity<>(saveParents, HttpStatus.CREATED);
    }
    //update parent
    @PutMapping("parents/{id}")
    public ResponseEntity<parents>updateParents(@PathVariable Long id,@RequestBody parents updateParents){
        Optional<parents> optionalParents = parentRepository.findById(id);
        if(optionalParents.isPresent()){
            parents existingParents = optionalParents.get();
            existingParents.setParentName(updateParents.getParentName());
            existingParents.setParentEmail(updateParents.getParentEmail());
            existingParents.setParentPhoneNum(updateParents.getParentPhoneNum());
            parentRepository.save(existingParents);
            return new ResponseEntity<>(existingParents,HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //delete parent
    @DeleteMapping("parents/{id}")
    public ResponseEntity<Void>deleteParents(@PathVariable long id){
        Optional<parents>optionalParents= parentRepository.findById(id);
        if(optionalParents.isPresent()) {
            parentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


}
