package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.DetailKelasDto;
import com.testing.projectspring.model.dto.KelasDto;
import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.request.DetailKelasRequest;
import com.testing.projectspring.model.entity.DetailKelas;
import com.testing.projectspring.repository.DetailKelasRepository;
import com.testing.projectspring.service.DetailKelasService;
import com.testing.projectspring.service.KelasService;
import com.testing.projectspring.service.MataKuliahService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailKelasServicecImpl implements DetailKelasService {

    @Autowired
    private DetailKelasRepository detailKelasRepository;
    @Autowired
    private KelasService kelasService;
    @Autowired
    private MataKuliahService mataKuliahService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createDetailKelas(DetailKelasRequest detailKelasRequest) {
        KelasDto kelasDto = kelasService.getKelasByCode(detailKelasRequest.getKelasCode());
        MataKuliahDto mataKuliahDto = mataKuliahService.getMataKuliahByCode(detailKelasRequest.getMatkulCode());

        if (kelasDto == null) {
            throw new NotFoundException("Kelas Not Exists");
        }

        if (mataKuliahDto == null) {
            throw new NotFoundException("Mata Kuliah Not Exists");
        }

        DetailKelasDto detailKelasDto = new DetailKelasDto();
        detailKelasDto.setKelas(kelasDto);
        detailKelasDto.setMataKuliah(mataKuliahDto);
        detailKelasDto.setTime(detailKelasRequest.getTime());

        DetailKelas detailKelas = modelMapper.map(detailKelasDto, DetailKelas.class);
        detailKelasRepository.save(detailKelas);
    }
}
