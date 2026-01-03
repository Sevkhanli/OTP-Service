package az.edu.itbrains.Aptekk.services;

import az.edu.itbrains.Aptekk.dtos.response.FeaturesResponseDto;

import java.util.List;

public interface FeaturesService {
    List<FeaturesResponseDto> getFeaturesList();
}
