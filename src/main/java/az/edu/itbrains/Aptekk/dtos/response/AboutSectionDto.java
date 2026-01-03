package az.edu.itbrains.Aptekk.dtos.response;

import lombok.Data;

@Data
public class AboutSectionDto {
    private Long id;
    private String title;
    private String description;
    private String videoUrl;  // Video URL buradadır
}
