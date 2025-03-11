package com.example.Examen_AccesoADatos.Repository;

import com.example.Examen_AccesoADatos.Model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}
