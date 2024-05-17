package com.patrickrodrigues.apicursoprogramacao.module.courses.useCases;

import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseRepository;
import com.patrickrodrigues.apicursoprogramacao.module.courses.dto.RequestUpdateCourseDTO;
import com.patrickrodrigues.apicursoprogramacao.module.courses.dto.ResponseUpdateCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCourseUseCase {
    @Autowired
    CourseRepository courseRepository;
    public ResponseUpdateCourseDTO execute(UUID id, RequestUpdateCourseDTO requestUpdateCourseDTO){
        var course = this.courseRepository.findById(id).orElseThrow();

        course.setName(requestUpdateCourseDTO.getName());
        course.setCategory(requestUpdateCourseDTO.getCategory());
        course.setActive(requestUpdateCourseDTO.getActive());

        this.courseRepository.save(course);

        var responseUpdateDTO = ResponseUpdateCourseDTO.builder()
                .name(requestUpdateCourseDTO.getName())
                .category(requestUpdateCourseDTO.getCategory())
                .active(requestUpdateCourseDTO.getActive())
                .build();

        return responseUpdateDTO;
    }
}
