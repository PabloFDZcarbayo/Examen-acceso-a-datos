package Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


}
