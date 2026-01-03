package az.edu.itbrains.Aptekk.services.Impl;

import az.edu.itbrains.Aptekk.dtos.response.CureDetailResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.CureStoreDto;
import az.edu.itbrains.Aptekk.repository.CureRepository;
import az.edu.itbrains.Aptekk.services.CureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CureServiceImpl implements CureService {
    private final CureRepository cureRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CureDetailResponseDto> getCuresList(Long id) {
        return cureRepository.findById(id).stream().map(cure -> modelMapper.map(cure, CureDetailResponseDto.class)).toList();
    }

    @Override
    public List<CureStoreDto> getCuresForStore() {
        return cureRepository.findAll().stream().map(cure -> modelMapper.map(cure, CureStoreDto.class)).toList();
    }
}
