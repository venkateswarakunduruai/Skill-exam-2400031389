package com.klef.exam.service;

import com.klef.exam.entity.University;

import java.util.List;

public interface UniversityService {

    University insert(University university);

    University update(University university);

    String delete(Long universityId);

    List<University> displayAll();

    University displayById(Long universityId);

    List<University> findByName(String name);

    List<University> findByType(String type);
}
