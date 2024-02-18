package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.ExistsDataException;
import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.DosenDto;
import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.request.MataKuliahRequest;
import com.testing.projectspring.model.entity.Dosen;
import com.testing.projectspring.model.entity.MataKuliah;
import com.testing.projectspring.repository.MataKuliahRepository;
import com.testing.projectspring.service.DosenService;
import com.testing.projectspring.service.MataKuliahService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MataKuliahServiceImpl implements MataKuliahService {

    @Autowired
    private MataKuliahRepository mataKuliahRepository;
    @Autowired
    private DosenService dosenService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MataKuliahDto getMataKuliahByCode(String matkulCode) {
        MataKuliah mataKuliah = mataKuliahRepository.findById(matkulCode).orElseThrow(() -> new NotFoundException("Mata Kuliah Not Found"));
        MataKuliahDto mataKuliahDto = modelMapper.map(mataKuliah, MataKuliahDto.class);
        return mataKuliahDto;
    }

    @Override
    public void createMataKuliah(MataKuliahRequest mataKuliahRequest) {
        Optional<MataKuliah> mataKuliah = mataKuliahRepository.findById(mataKuliahRequest.getMatkulCode());
        if (!mataKuliah.isEmpty()) {
            throw new ExistsDataException("Mata Kuliah Cannot Duplicate");
        }

        MataKuliah createMataKuliah = new MataKuliah();
        DosenDto dosenDto = dosenService.getDosenByNid(mataKuliahRequest.getNid());
        Dosen dosen = modelMapper.map(dosenDto, Dosen.class);
        createMataKuliah.setMatkulCode(mataKuliahRequest.getMatkulCode());
        createMataKuliah.setMatkulName(mataKuliahRequest.getMatkulName());
        createMataKuliah.setNid(dosen);
        createMataKuliah.setSemester(mataKuliahRequest.getSemester());
        createMataKuliah.setCapacity(mataKuliahRequest.getCapacity());

        mataKuliahRepository.save(createMataKuliah);
    }

    @Override
    public void updateActiveMataKuliah(String matkulCode, Boolean activated) {
        MataKuliah mataKuliah = mataKuliahRepository.findById(matkulCode).orElseThrow(() -> new NotFoundException("Mata Kuliah Not Found"));
        if (activated) {
            mataKuliah.setIsActive(true);
        } else {
            mataKuliah.setIsActive(false);
        }
        mataKuliahRepository.save(mataKuliah);
    }

    @Override
    public void updateMataKuliah(String matkulCode, MataKuliahRequest mataKuliahRequest) {
        MataKuliah mataKuliah = mataKuliahRepository.findById(matkulCode).orElseThrow(() -> new NotFoundException("Mata Kuliah Not Found"));
        mataKuliah = modelMapper.map(mataKuliahRequest, MataKuliah.class);
        mataKuliahRepository.save(mataKuliah);
    }

    @Override
    public List<MataKuliahDto> getMatkulByNid(String nid) {
        DosenDto dosenDto = dosenService.getDosenByNid(nid);
        if (dosenDto == null) {
            throw new NotFoundException("Dosen Not Found");
        }

        List<MataKuliah> mataKuliahList = mataKuliahRepository.findByNid(nid);
        List<MataKuliahDto> mataKuliahDtos = mataKuliahList.stream().map(e -> modelMapper.map(e, MataKuliahDto.class)).collect(Collectors.toList());
        return mataKuliahDtos;
    }
}
