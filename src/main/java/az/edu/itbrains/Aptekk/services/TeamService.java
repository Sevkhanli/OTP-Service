package az.edu.itbrains.Aptekk.services;

import az.edu.itbrains.Aptekk.dtos.response.AboutResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.TeamResponseDto;

import java.util.List;

public interface TeamService {
    List<TeamResponseDto> getTeamsList();

}
