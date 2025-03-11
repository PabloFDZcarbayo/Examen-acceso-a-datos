package com.example.Examen_AccesoADatos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "alquileres")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coche_id", nullable = false)
    private Coche carId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario userId;

    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Status {
        PENDIENTE, EN_CURSO, FINALIZADO
    }
}
