package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.ExistsDataException;
import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.KelasDto;
import com.testing.projectspring.model.dto.request.KelasRequest;
import com.testing.projectspring.model.entity.Kelas;
import com.testing.projectspring.repository.KelasRepository;
import com.testing.projectspring.service.KelasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KelasServiceImpl implements KelasService {

    @Autowired
    private KelasRepository kelasRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createKelas(KelasRequest kelasRequest) {
        Optional<Kelas> kelas = kelasRepository.findById(kelasRequest.getKelasCode());
        if (!kelas.isEmpty()) {
            throw new ExistsDataException("Kelas Cannot Duplicate");
        }

        Kelas createKelas = new Kelas();
        createKelas.setKelasCode(kelasRequest.getKelasCode());
        createKelas.setGedung(kelasRequest.getGedung());
        createKelas.setLantai(kelasRequest.getLantai());

        kelasRepository.save(createKelas);
    }

    @Override
    public List<KelasDto> getAllKelas() {
        List<Kelas> kelas = kelasRepository.findAll();
        List<KelasDto> kelasDtos = kelas.stream().map(e -> modelMapper.map(e, KelasDto.class)).collect(Collectors.toList());
        return kelasDtos;
    }

    @Override
    public KelasDto getKelasByCode(String kelasCode) {
        Kelas kelas = kelasRepository.findById(kelasCode).orElseThrow(() -> new NotFoundException("Kelas Not Found"));
        KelasDto kelasDto = modelMapper.map(kelas, KelasDto.class);
        return kelasDto;
    }
}
