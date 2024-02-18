package com.testing.projectspring.model.dto.request;

import com.testing.projectspring.model.entity.Dosen;
import lombok.Data;

@Data
public class MataKuliahRequest {

    private String matkulCode;
    private String nid;
    private String matkulName;
    private Integer semester;
    private Integer capacity = 1;

}
