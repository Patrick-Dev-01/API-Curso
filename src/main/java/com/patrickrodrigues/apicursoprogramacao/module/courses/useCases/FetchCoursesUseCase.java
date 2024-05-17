package com.patrickrodrigues.apicursoprogramacao.module.courses.useCases;

import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseEntity;
import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseRepository;
import com.patrickrodrigues.apicursoprogramacao.module.courses.dto.FetchCoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FetchCoursesUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<FetchCoursesDTO> execute(String name, String category){
        List<CourseEntity> courses = this.courseRepository.findAll();
        List fetchedCoursesDTO = new ArrayList<FetchCoursesDTO>();

        if(!category.isEmpty() || !name.isEmpty()){
            List<CourseEntity> filteredCourses = courses.stream()
                .filter(c -> c.getCategory().contains(category) && c.getName().contains(name)).toList();

            for (CourseEntity course: filteredCourses){
                var fetchedCourse = FetchCoursesDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .category(course.getCategory())
                        .active(course.getActive()).build();

                fetchedCoursesDTO.add(fetchedCourse);
            }
        }

        else {
            for (CourseEntity course: courses){
                var fetchedCourse = FetchCoursesDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .category(course.getCategory())
                        .active(course.getActive()).build();

                fetchedCoursesDTO.add(fetchedCourse);
            }
        }

        return fetchedCoursesDTO;
    }
}
