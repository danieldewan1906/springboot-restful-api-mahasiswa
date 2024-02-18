package com.testing.projectspring.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetailKelasDto {

    private Integer id;

    private KelasDto kelas;

    private MataKuliahDto mataKuliah;

    private String time;

    private Date createdAt = new Date();
}
