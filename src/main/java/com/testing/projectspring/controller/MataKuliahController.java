package com.testing.projectspring.controller;

import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.WebResponse;
import com.testing.projectspring.model.dto.request.MataKuliahRequest;
import com.testing.projectspring.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matakuliah")
public class MataKuliahController {

    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping("/{matkulCode}")
    public WebResponse<MataKuliahDto> getMataKuliahByCode(@PathVariable("matkulCode") String matkulCode) {
        MataKuliahDto mataKuliahDto = mataKuliahService.getMataKuliahByCode(matkulCode);
        return new WebResponse<>(200, "OK", mataKuliahDto);
    }

    @PostMapping("/")
    public WebResponse<?> createMataKuliah(@RequestBody MataKuliahRequest mataKuliahRequest) {
        mataKuliahService.createMataKuliah(mataKuliahRequest);
        return new WebResponse<>(200, "OK", "Successfully Create mata Kuliah");
    }

    @PutMapping("/{matkulCode}")
    public WebResponse<?> updateActiveMataKuliah(@PathVariable("matkulCode") String matkulCode, @RequestParam("activated") Boolean activated) {
        mataKuliahService.updateActiveMataKuliah(matkulCode, activated);
        return new WebResponse<>(200, "OK", "Successfully Update Mata Kuliah");
    }
}
