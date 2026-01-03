package az.edu.itbrains.Aptekk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cures")
public class Cure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2000)
    private String title;
    @Column(length = 2000)
    private String description;
    private float price;
    @Column(length = 2000)
    private String orderingInformation;
    @Column(length = 2000)
    private String Specifications;
    @Column(length = 2000)
    private String imageUrl;


}
