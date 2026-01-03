package az.edu.itbrains.Aptekk.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CureNewProductDto {
    private Long id;
    private String title;
    private float price;
    private String imgUrl;
}
