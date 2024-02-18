package com.testing.projectspring.service;

import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.request.MataKuliahRequest;

import java.util.List;

public interface MataKuliahService {

    MataKuliahDto getMataKuliahByCode(String matkulCode);
    void createMataKuliah(MataKuliahRequest mataKuliahRequest);
    void updateActiveMataKuliah(String matkulCode, Boolean activated);
    void updateMataKuliah(String matkulCode, MataKuliahRequest mataKuliahRequest);
    List<MataKuliahDto> getMatkulByNid(String nid);
}
