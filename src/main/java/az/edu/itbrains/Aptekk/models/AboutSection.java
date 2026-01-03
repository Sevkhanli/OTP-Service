package az.edu.itbrains.Aptekk.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AboutSection {
    private String title;
    private String description;
    private String videoUrl;
    private Integer sortOrder;

    private Boolean isYouTube;
    private String videoId;
}