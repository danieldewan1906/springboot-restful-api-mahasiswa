package com.testing.projectspring.service;

import com.testing.projectspring.model.dto.DosenDto;
import com.testing.projectspring.model.dto.request.DosenRequest;

import java.util.List;

public interface DosenService {
    List<DosenDto> getAllDosen();
    DosenDto getDosenByNid(String nid);
    DosenDto createDosen(DosenRequest dosenRequest);
    void deleteDosen(String nid);
}
