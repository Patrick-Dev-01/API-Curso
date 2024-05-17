package com.patrickrodrigues.apicursoprogramacao.module.courses.useCases;

import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;
    public void execute(UUID id){
        var course = this.courseRepository.findById(id).orElseThrow();
        this.courseRepository.delete(course);
    }
}
