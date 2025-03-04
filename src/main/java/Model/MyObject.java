package Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "objects")
public class MyObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


}
