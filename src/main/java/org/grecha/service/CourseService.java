package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.entity.Course;
import org.grecha.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
