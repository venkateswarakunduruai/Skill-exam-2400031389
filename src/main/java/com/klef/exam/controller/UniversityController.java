package com.klef.exam.controller;

import com.klef.exam.entity.University;
import com.klef.exam.service.UniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
@Tag(name = "University API", description = "CRUD operations for University")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @Operation(summary = "Insert a new University")
    @PostMapping("/insert")
    public ResponseEntity<University> insert(@RequestBody University university) {
        return ResponseEntity.ok(universityService.insert(university));
    }

    @Operation(summary = "Update an existing University")
    @PutMapping("/update")
    public ResponseEntity<University> update(@RequestBody University university) {
        return ResponseEntity.ok(universityService.update(university));
    }

    @Operation(summary = "Delete a University by ID")
    @DeleteMapping("/delete/{universityId}")
    public ResponseEntity<String> delete(@PathVariable Long universityId) {
        return ResponseEntity.ok(universityService.delete(universityId));
    }

    @Operation(summary = "Display all Universities")
    @GetMapping("/displayall")
    public ResponseEntity<List<University>> displayAll() {
        return ResponseEntity.ok(universityService.displayAll());
    }

    @Operation(summary = "Display University by ID")
    @GetMapping("/displaybyid/{universityId}")
    public ResponseEntity<University> displayById(@PathVariable Long universityId) {
        return ResponseEntity.ok(universityService.displayById(universityId));
    }

    @Operation(summary = "Find Universities by Name")
    @GetMapping("/findbyname")
    public ResponseEntity<List<University>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(universityService.findByName(name));
    }

    @Operation(summary = "Find Universities by Type")
    @GetMapping("/findbytype")
    public ResponseEntity<List<University>> findByType(@RequestParam String type) {
        return ResponseEntity.ok(universityService.findByType(type));
    }
}
