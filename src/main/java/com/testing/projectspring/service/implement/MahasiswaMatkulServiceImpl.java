package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.ExistsDataException;
import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.MahasiswaDto;
import com.testing.projectspring.model.dto.MahasiswaMatkulDto;
import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.request.MataKuliahRequest;
import com.testing.projectspring.model.entity.Mahasiswa;
import com.testing.projectspring.model.entity.MahasiswaMatkul;
import com.testing.projectspring.model.entity.MataKuliah;
import com.testing.projectspring.repository.MahasiswaMatkulRepository;
import com.testing.projectspring.service.MahasiswaMatkulService;
import com.testing.projectspring.service.MahasiswaService;
import com.testing.projectspring.service.MataKuliahService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaMatkulServiceImpl implements MahasiswaMatkulService {

    @Autowired
    private MahasiswaMatkulRepository mahasiswaMatkulRepository;
    @Autowired
    private MahasiswaService mahasiswaService;
    @Autowired
    private MataKuliahService mataKuliahService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveMatkulMahasiswa(String nim, MahasiswaMatkulDto mahasiswaMatkulDtoList) {
        MahasiswaDto mahasiswaDto = mahasiswaService.getMahasiswaByNim(nim);
        if (mahasiswaDto == null) {
            throw new NotFoundException("Mahasiswa Not Found");
        }

        Mahasiswa mahasiswa = modelMapper.map(mahasiswaDto, Mahasiswa.class);
        List<MahasiswaMatkul> mahasiswaMatkuls = new ArrayList<>();
        for(String matkulCode : mahasiswaMatkulDtoList.getMatkulCode()) {
            MataKuliahDto mataKuliahDto = mataKuliahService.getMataKuliahByCode(matkulCode);
            if (mataKuliahDto == null) {
                throw new NotFoundException("Mata Kuliah Not Found");
            }

            if (!mataKuliahDto.getSemester().equals(mahasiswaDto.getSemester())) {
                throw new ExistsDataException("Mata kuliah " + mataKuliahDto.getMatkulName() + " exists at semester " + mataKuliahDto.getSemester());
            }

            if (mataKuliahDto.getCapacity() == 0) {
                throw new NotFoundException("Capacity Mata Kuliah "+ mataKuliahDto.getMatkulName() + " full");
            }

            MataKuliah mataKuliah = modelMapper.map(mataKuliahDto, MataKuliah.class);
            MahasiswaMatkul mahasiswaMatkul = new MahasiswaMatkul();
            mahasiswaMatkul.setMahasiswa(mahasiswa);
            mahasiswaMatkul.setMataKuliah(mataKuliah);
            mahasiswaMatkuls.add(mahasiswaMatkul);

            mataKuliahDto.setCapacity(mataKuliahDto.getCapacity() - 1);
            MataKuliahRequest mataKuliahRequest = modelMapper.map(mataKuliahDto, MataKuliahRequest.class);
            mataKuliahService.updateMataKuliah(matkulCode, mataKuliahRequest);
        }

        mahasiswaMatkulRepository.saveAll(mahasiswaMatkuls);
    }
}
