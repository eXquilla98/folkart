package com.folkart.folkart.repository;

import com.folkart.folkart.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<students,Long> {


}
