package com.testing.projectspring.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MataKuliahDto {

    private String matkulCode;
    private DosenDto nid;
    private String matkulName;
    private Integer semester;
    private Integer capacity;
    private Boolean isActive = true;
    private Date createdAt = new Date();
}
