package com.testing.projectspring.model.dto.response;

import lombok.Data;

@Data
public class MataKuliahResponse {

    private String matkulCode;

    private String matkulName;

    private Integer semester;

    private Integer capacity;

    private Boolean isActive;

}
