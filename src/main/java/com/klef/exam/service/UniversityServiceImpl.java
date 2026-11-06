package com.klef.exam.service;

import com.klef.exam.entity.University;
import com.klef.exam.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University insert(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University update(University university) {
        University existing = universityRepository.findById(university.getUniversityId())
                .orElseThrow(() -> new RuntimeException("University not found with ID: " + university.getUniversityId()));

        existing.setName(university.getName());
        existing.setType(university.getType());
        existing.setStatus(university.getStatus());
        existing.setLocation(university.getLocation());

        return universityRepository.save(existing);
    }

    @Override
    public String delete(Long universityId) {
        universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("University not found with ID: " + universityId));
        universityRepository.deleteById(universityId);
        return "University deleted successfully";
    }

    @Override
    public List<University> displayAll() {
        return universityRepository.findAll();
    }

    @Override
    public University displayById(Long universityId) {
        return universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("University not found with ID: " + universityId));
    }

    @Override
    public List<University> findByName(String name) {
        return universityRepository.findByName(name);
    }

    @Override
    public List<University> findByType(String type) {
        return universityRepository.findByType(type);
    }
}
