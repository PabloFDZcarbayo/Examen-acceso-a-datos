package com.example.Examen_AccesoADatos.Service;

import com.example.Examen_AccesoADatos.Model.Usuario;
import com.example.Examen_AccesoADatos.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {

    @Autowired
    Repository repository;

    public Usuario save(Usuario object) {
        return repository.save(object);
    }

    public List<Usuario> getAllObjects() {
        return repository.findAll();
    }
    }
