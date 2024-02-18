package com.testing.projectspring.service.implement;

import com.testing.projectspring.error.ExistsDataException;
import com.testing.projectspring.error.NotFoundException;
import com.testing.projectspring.model.dto.DosenDto;
import com.testing.projectspring.model.dto.MataKuliahDto;
import com.testing.projectspring.model.dto.request.DosenRequest;
import com.testing.projectspring.model.dto.response.MataKuliahResponse;
import com.testing.projectspring.model.entity.Dosen;
import com.testing.projectspring.model.entity.MataKuliah;
import com.testing.projectspring.repository.DosenRepository;
import com.testing.projectspring.repository.MataKuliahRepository;
import com.testing.projectspring.service.DosenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DosenServiceImpl implements DosenService {

    @Autowired
    private DosenRepository dosenRepository;
    @Autowired
    private MataKuliahRepository mataKuliahRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DosenDto> getAllDosen() {
        List<Dosen> listDosen = dosenRepository.findAll();
        List<DosenDto> listDosenDto = listDosen
                .stream()
                .map(e -> modelMapper.map(e, DosenDto.class))
                .collect(Collectors.toList());
        return listDosenDto;
    }

    @Override
    public DosenDto getDosenByNid(String nid) {
        Dosen dosen = dosenRepository.findById(nid).orElseThrow(() -> new NotFoundException("Dosen Not Found"));
        List<MataKuliah> mataKuliahList = mataKuliahRepository.findByNid(nid);
        List<MataKuliahResponse> mataKuliahDtos = mataKuliahList.stream().map(e -> modelMapper.map(e, MataKuliahResponse.class)).collect(Collectors.toList());
        DosenDto dosenDto = modelMapper.map(dosen, DosenDto.class);
        dosenDto.setMataKuliah(mataKuliahDtos);
        return dosenDto;
    }

    @Override
    public DosenDto createDosen(DosenRequest dosenRequest) {
        Optional<Dosen> dosen = dosenRepository.findById(dosenRequest.getNid());
        if (!dosen.isEmpty()) {
            throw new ExistsDataException("Dosen Cannot Duplicate");
        }

        Dosen createDosen = new Dosen();
        createDosen.setNid(dosenRequest.getNid());
        createDosen.setDosenName(dosenRequest.getDosenName());

        dosenRepository.save(createDosen);
        DosenDto dosenDto = modelMapper.map(createDosen, DosenDto.class);
        return dosenDto;
    }

    @Override
    public void deleteDosen(String nid) {
        Dosen dosen = dosenRepository.findById(nid).orElseThrow(() -> new NotFoundException("Dosen Not Found"));
        dosenRepository.deleteById(dosen.getNid());
    }
}
