package az.edu.itbrains.Aptekk.services.Impl;

import az.edu.itbrains.Aptekk.dtos.response.AboutResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.FeaturesResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.TeamResponseDto;
import az.edu.itbrains.Aptekk.repository.AboutRepository;
import az.edu.itbrains.Aptekk.repository.FeatureRepository;
import az.edu.itbrains.Aptekk.repository.TeamRepository;
import az.edu.itbrains.Aptekk.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;
    @Override

    public AboutResponseDto getAboutsList() {
        return (aboutRepository.findAll().stream()
                .findFirst()
                .map(about -> modelMapper.map(about, AboutResponseDto.class))
                .orElseThrow(() -> new RuntimeException("About tapılmadı")));

    }


}
