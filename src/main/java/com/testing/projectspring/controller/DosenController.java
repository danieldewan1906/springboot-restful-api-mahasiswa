package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.DosenDto;
import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.model.dto.request.DosenRequest;
import com.testing.projectspring.service.DosenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dosen")
public class DosenController {

    @Autowired
    private DosenService dosenService;

    @GetMapping("/")
    public WebResponse<List<DosenDto>> getAllDosen() {
        List<DosenDto> dosenDtos = dosenService.getAllDosen();
        return new WebResponse<>(
                200,
                "OK",
                dosenDtos
        );
    }

    @GetMapping("/{nid}")
    public WebResponse<DosenDto> getDosenByNid(@PathVariable("nid") String nid) {
        DosenDto dosenDto = dosenService.getDosenByNid(nid);
        return new WebResponse<>(200, "OK", dosenDto);
    }

    @PostMapping("/")
    public WebResponse<DosenDto> createDosen(@RequestBody DosenRequest dosenRequest) {
        DosenDto dosenDto = dosenService.createDosen(dosenRequest);
        return new WebResponse<>(200, "OK", dosenDto);
    }

    @DeleteMapping("/{nid}")
    public WebResponse<?> deleteDosen(@PathVariable("nid") String nid) {
        dosenService.deleteDosen(nid);
        return new WebResponse<>(200, "OK", "Successfully Delete Dosen");
    }
}
