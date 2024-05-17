package com.patrickrodrigues.apicursoprogramacao.module.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUpdateCourseDTO {
    private String name;
    private String category;
    private Boolean active;
}
