package com.example.Examen_AccesoADatos.Controler;

import com.example.Examen_AccesoADatos.Model.API_Response;
import com.example.Examen_AccesoADatos.Model.Usuario;
import com.example.Examen_AccesoADatos.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/examen")
public class Object_Controler {
    private final service objectService;

    @Autowired
    public Object_Controler(service objectService) {
        this.objectService = objectService;
    }

    @PostMapping("/save")
    public ResponseEntity <API_Response<Usuario>> save(@RequestBody Usuario object) {
        try {
            Usuario newObject = objectService.save(object);
            return ResponseEntity.ok(new API_Response<>(true, "Object saved successfully", newObject));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<API_Response<List<Usuario>>> getAllObjects() {
        try {
            List<Usuario> objects = objectService.getAllObjects();
            return ResponseEntity.ok(new API_Response<>(true, "Results:", objects));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error", null));
        }
    }
}