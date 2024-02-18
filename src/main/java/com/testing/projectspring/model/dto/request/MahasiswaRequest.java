package com.testing.projectspring.model.dto.request;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class MahasiswaRequest {

    private String nim;

    private String mahasiswaName;

    private Integer semester = 1;

}
