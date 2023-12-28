package com.folkart.folkart.services;

import com.folkart.folkart.model.parents;
import com.folkart.folkart.repository.parentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class parentService {

    @Autowired
    private parentRepository parentRepository;

    public List<parents> getAllParents() {
        return parentRepository.findAll();
    }

    public Optional<parents> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public parents createParent(parents parent) {
        return parentRepository.save(parent);
    }

    public Optional<parents> updateParent(Long id, parents updateParent) {
        Optional<parents> optionalParent = parentRepository.findById(id);
        if (optionalParent.isPresent()) {
            parents existingParent = optionalParent.get();
            existingParent.setParentName(updateParent.getParentName());
            existingParent.setParentEmail(updateParent.getParentEmail());
            existingParent.setParentPhoneNum(updateParent.getParentPhoneNum());
            return Optional.of(parentRepository.save(existingParent));
        } else {
            return Optional.empty();
        }
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
