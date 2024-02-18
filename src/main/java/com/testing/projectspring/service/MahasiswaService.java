package com.testing.projectspring.service;

import com.testing.projectspring.model.dto.MahasiswaDto;
import com.testing.projectspring.model.dto.request.MahasiswaRequest;

public interface MahasiswaService {

    void createMahasiswa(MahasiswaRequest mahasiswaRequest);
    MahasiswaDto getMahasiswaByNim(String nim);
}
