package az.edu.itbrains.Aptekk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "about")

public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String title;
    private String description;


    @ElementCollection
    @CollectionTable(name = "about_section", joinColumns = @JoinColumn(name = "about_id"))
    private List <AboutSection> sections;

}
