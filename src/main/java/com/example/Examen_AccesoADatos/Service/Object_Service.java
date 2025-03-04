package com.example.Examen_AccesoADatos.Service;

import com.example.Examen_AccesoADatos.Model.MyObject;
import com.example.Examen_AccesoADatos.Repository.Object_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Object_Service {

    @Autowired
    Object_Repository objectRepository;

    public MyObject save(MyObject object) {
        return objectRepository.save(object);
    }

    public List<MyObject> getAllObjects() {
        return objectRepository.findAll();
    }
    }
