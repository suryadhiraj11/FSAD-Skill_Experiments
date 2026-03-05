package com.klu.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Course;
import com.klu.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return repo.findById(id);
    }

    public Course updateCourse(Course course) {
        return repo.save(course);
    }

    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitle(title);
    }
}