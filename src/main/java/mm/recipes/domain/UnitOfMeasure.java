package mm.recipes.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
