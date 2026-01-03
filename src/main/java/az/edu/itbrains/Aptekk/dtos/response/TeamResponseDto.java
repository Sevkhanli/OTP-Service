package az.edu.itbrains.Aptekk.dtos.response;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TeamResponseDto {
    private Long id;
    private String name;
    private String position;
    private String description;
    private String imageUrl;
}