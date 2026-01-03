package az.edu.itbrains.Aptekk.services.Impl;


import az.edu.itbrains.Aptekk.dtos.response.FeaturesResponseDto;
import az.edu.itbrains.Aptekk.repository.FeatureRepository;
import az.edu.itbrains.Aptekk.services.FeaturesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeaturesServiceImpl implements FeaturesService {
    private final FeatureRepository featureRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FeaturesResponseDto> getFeaturesList() {
        return featureRepository.findAll().stream()
                .map(feature -> modelMapper.map (feature, FeaturesResponseDto.class))
                .toList();
    }


}
