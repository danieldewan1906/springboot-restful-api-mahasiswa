package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.KelasDto;
import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.model.dto.request.KelasRequest;
import com.testing.projectspring.model.entity.Kelas;
import com.testing.projectspring.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @PostMapping("/")
    public WebResponse<?> createKelas(@RequestBody KelasRequest kelasRequest) {
        kelasService.createKelas(kelasRequest);
        return new WebResponse<>(200, "OK", "Successfully Save Kelas");
    }

    @GetMapping("/")
    public WebResponse<List<KelasDto>> getAllKelas() {
        List<KelasDto> kelasDtos = kelasService.getAllKelas();
        return new WebResponse<>(200, "OK", kelasDtos);
    }
}
