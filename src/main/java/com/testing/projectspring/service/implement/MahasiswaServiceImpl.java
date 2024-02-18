package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.ExistsDataException;
import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.MahasiswaDto;
import com.testing.projectspring.model.dto.request.MahasiswaRequest;
import com.testing.projectspring.model.entity.Mahasiswa;
import com.testing.projectspring.repository.MahasiswaRepository;
import com.testing.projectspring.service.MahasiswaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createMahasiswa(MahasiswaRequest mahasiswaRequest) {
        Optional<Mahasiswa> mahasiswa = mahasiswaRepository.findById(mahasiswaRequest.getNim());
        if (!mahasiswa.isEmpty()) {
            throw new ExistsDataException("Mahasiswa cannot duplicate");
        }

        Mahasiswa createMahasiswa = modelMapper.map(mahasiswaRequest, Mahasiswa.class);

        mahasiswaRepository.save(createMahasiswa);
    }

    @Override
    public MahasiswaDto getMahasiswaByNim(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(nim).orElseThrow(() -> new NotFoundException("Mahasiswa Not Found"));
        MahasiswaDto mahasiswaDto = modelMapper.map(mahasiswa, MahasiswaDto.class);
        return mahasiswaDto;
    }
}
