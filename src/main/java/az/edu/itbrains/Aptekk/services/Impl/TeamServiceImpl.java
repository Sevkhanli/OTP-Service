package az.edu.itbrains.Aptekk.services.Impl;


import az.edu.itbrains.Aptekk.dtos.response.TeamResponseDto;
import az.edu.itbrains.Aptekk.repository.TeamRepository;
import az.edu.itbrains.Aptekk.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TeamResponseDto> getTeamsList() {
        return teamRepository.findAll().stream()
                .map(team -> modelMapper.map (team, TeamResponseDto.class))
                .toList();



    }


}

