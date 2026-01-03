package az.edu.itbrains.Aptekk.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class AboutResponseDto {
    private Long id;
    private String title;
    private String description;
    private List<AboutSectionDto> sections;  // Sections kolleksiyası
}

