package com.example.Examen_AccesoADatos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "coches")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String plateNumber;
    private String brand;
    private String model;
    private Integer year;
    private Boolean available = true;

    @OneToMany(mappedBy = "carId", cascade = CascadeType.ALL)
    private List<Alquiler> alquileres;


}
