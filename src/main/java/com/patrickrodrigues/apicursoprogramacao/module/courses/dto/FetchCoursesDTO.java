package com.patrickrodrigues.apicursoprogramacao.module.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FetchCoursesDTO {
    private UUID id;
    private String name;
    private String category;
    private Boolean active;
}
