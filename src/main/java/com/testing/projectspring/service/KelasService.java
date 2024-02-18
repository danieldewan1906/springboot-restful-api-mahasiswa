package com.testing.projectspring.service;

import com.testing.projectspring.model.dto.KelasDto;
import com.testing.projectspring.model.dto.request.KelasRequest;

import java.util.List;

public interface KelasService {

    void createKelas(KelasRequest kelasRequest);
    List<KelasDto> getAllKelas();

    KelasDto getKelasByCode(String kelasCode);
}
