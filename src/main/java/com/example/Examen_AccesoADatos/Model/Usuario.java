package com.example.Examen_AccesoADatos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String licenseNumber;

    private String pfc_number;
    private String pfc_date;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Alquiler> alquileres;



}
