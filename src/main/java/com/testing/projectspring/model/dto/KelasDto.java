package com.testing.projectspring.model.dto;
import lombok.Data;

import java.util.Date;

@Data
public class KelasDto {

    private String kelasCode;

    private String gedung;

    private String lantai;

    private Date createdAt = new Date();

}
