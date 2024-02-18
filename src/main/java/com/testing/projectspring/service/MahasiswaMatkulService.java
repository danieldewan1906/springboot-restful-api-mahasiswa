package com.testing.projectspring.service;

import com.testing.projectspring.model.dto.MahasiswaMatkulDto;


public interface MahasiswaMatkulService {

    void saveMatkulMahasiswa(String nim, MahasiswaMatkulDto mahasiswaMatkulDtoList);
}
