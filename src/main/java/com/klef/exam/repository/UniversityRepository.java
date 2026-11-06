package com.klef.exam.repository;

import com.klef.exam.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    List<University> findByName(String name);

    List<University> findByType(String type);
}
