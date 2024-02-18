package com.testing.projectspring.model.dto;
import com.testing.projectspring.model.dto.response.MataKuliahResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DosenDto {

    private String nid;

    private String dosenName;

    private Boolean isActive = true;

    private Date createdAt;

    private List<MataKuliahResponse> mataKuliah;
}
