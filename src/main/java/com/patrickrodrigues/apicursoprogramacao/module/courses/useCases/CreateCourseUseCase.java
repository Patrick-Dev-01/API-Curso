package com.patrickrodrigues.apicursoprogramacao.module.courses.useCases;

import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseEntity;
import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;
    public CourseEntity execute(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }
}
