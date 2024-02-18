package com.testing.projectspring.model.dto;

import com.testing.projectspring.model.entity.MataKuliah;
import lombok.Data;

import java.util.Date;

@Data
public class MahasiswaDto {

    private String nim;

    private String mahasiswaName;

    private Integer semester;

    private Boolean isActive;

    private Date createdAt;
}
