package az.edu.itbrains.Aptekk.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FeaturesResponseDto {
    private Long id;
    private String icon;
    private String title;
    private String description;
}
