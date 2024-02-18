package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.model.dto.request.DetailKelasRequest;
import com.testing.projectspring.service.DetailKelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detail/kelas")
public class DetailKelasController {

    @Autowired
    private DetailKelasService detailKelasService;

    @PostMapping("/")
    public WebResponse<?> createDetailKelas(@RequestBody DetailKelasRequest detailKelasRequest) {
        detailKelasService.createDetailKelas(detailKelasRequest);
        return new WebResponse<>(200, "OK", "Successfully Save Detail Kelas");
    }
}
