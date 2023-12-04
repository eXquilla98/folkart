package com.folkart.folkart.repository;

import com.folkart.folkart.model.parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface parentRepository extends JpaRepository<parents,Long> {
}
