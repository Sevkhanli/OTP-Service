package az.edu.itbrains.Aptekk.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CureDetailResponseDto {
    private Long id;
    private String title;
    private String description;
    private float price;
    private String orderingInformation;
    private String Specifications;
    private String imageUrl;


}
