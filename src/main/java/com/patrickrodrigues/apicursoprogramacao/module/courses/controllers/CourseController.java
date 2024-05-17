package com.patrickrodrigues.apicursoprogramacao.module.courses.controllers;

import com.patrickrodrigues.apicursoprogramacao.module.courses.CourseEntity;
import com.patrickrodrigues.apicursoprogramacao.module.courses.dto.RequestUpdateCourseDTO;
import com.patrickrodrigues.apicursoprogramacao.module.courses.useCases.CreateCourseUseCase;
import com.patrickrodrigues.apicursoprogramacao.module.courses.useCases.DeleteCourseUseCase;
import com.patrickrodrigues.apicursoprogramacao.module.courses.useCases.FetchCoursesUseCase;
import com.patrickrodrigues.apicursoprogramacao.module.courses.useCases.UpdateCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private FetchCoursesUseCase fetchCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;
    @Autowired
    DeleteCourseUseCase deleteCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity){
        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> fetch(@RequestParam String name, String category){
       try {
           var result = this.fetchCoursesUseCase.execute(name, category);
           return ResponseEntity.ok().body(result);
       }

       catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody RequestUpdateCourseDTO requestUpdateCourseDTO){
        try {
            var result = this.updateCourseUseCase.execute(UUID.fromString(id), requestUpdateCourseDTO);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        try {
            this.deleteCourseUseCase.execute(UUID.fromString(id));
            return ResponseEntity.ok().body("Deletado com Sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
