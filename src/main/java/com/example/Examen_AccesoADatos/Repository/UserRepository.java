package com.example.Examen_AccesoADatos.Repository;

import com.example.Examen_AccesoADatos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
