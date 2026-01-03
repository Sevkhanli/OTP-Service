package az.edu.itbrains.Aptekk.services;

import az.edu.itbrains.Aptekk.dtos.response.CureDetailResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.CureStoreDto;

import java.util.List;

public interface CureService {




    List<CureDetailResponseDto> getCuresList(Long id);

    List<CureStoreDto> getCuresForStore();
}
