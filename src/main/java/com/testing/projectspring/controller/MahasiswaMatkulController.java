package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.MahasiswaMatkulDto;
import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.service.MahasiswaMatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mahasiswa/matkul")
public class MahasiswaMatkulController {

    @Autowired
    private MahasiswaMatkulService mahasiswaMatkulService;

    @PostMapping("/{nim}")
    public WebResponse<?> saveMatkulMahasiswa(@PathVariable("nim") String nim, @RequestBody MahasiswaMatkulDto mahasiswaMatkulDto) {
        mahasiswaMatkulService.saveMatkulMahasiswa(nim, mahasiswaMatkulDto);
        return new WebResponse<>(200, "OK", "Successfully Save Mata Kuliah");
    }
}
