package az.edu.itbrains.Aptekk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Üzvün adı: Elizabeth Graham
    private String position; // Üzvün vəzifəsi: CEO/CO-FOUNDER
    private String description; // Üzv haqqında qısa təsvir
    private String imageUrl; // Üzvün şəklinin fayl/URL yolu
}