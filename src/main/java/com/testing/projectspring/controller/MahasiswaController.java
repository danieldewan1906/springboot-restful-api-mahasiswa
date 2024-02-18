package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.MahasiswaDto;
import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.model.dto.request.MahasiswaRequest;
import com.testing.projectspring.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping("/")
    public WebResponse<?> createMahasiswa(@RequestBody MahasiswaRequest mahasiswaRequest) {
        mahasiswaService.createMahasiswa(mahasiswaRequest);
        return new WebResponse<>(200, "OK", "Successfully Create Mahasiswa");
    }

    @GetMapping("/{nim}")
    public WebResponse<MahasiswaDto> getMahasiswaByNim(@PathVariable("nim") String nim) {
        MahasiswaDto mahasiswaDto = mahasiswaService.getMahasiswaByNim(nim);
        return new WebResponse<>(200, "OK", mahasiswaDto);
    }
}
