package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
}
