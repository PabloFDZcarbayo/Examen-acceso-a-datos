package com.example.Examen_AccesoADatos.Repository;

import com.example.Examen_AccesoADatos.Model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CocheRepository extends JpaRepository<Coche, Long> {
    List<Coche> findByBrand(String brand);

    List<Coche> findByAvailable(boolean b);
}
