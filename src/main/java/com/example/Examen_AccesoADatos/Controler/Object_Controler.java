package com.example.Examen_AccesoADatos.Controler;

import com.example.Examen_AccesoADatos.Model.API_Response;
import com.example.Examen_AccesoADatos.Model.Coche;
import com.example.Examen_AccesoADatos.Model.Usuario;
import com.example.Examen_AccesoADatos.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/examen")
public class Object_Controler {
    @Autowired
    private final Service service;

    @Autowired
    public Object_Controler(Service service) {
        this.service = service;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<API_Response<Usuario>> saveUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario newUser = service.saveUser(usuario);
            return ResponseEntity.ok(new API_Response<>(true, "User saved successfully", newUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<API_Response<Usuario>> getUser(@PathVariable("id") Long id) {
        try {
            Usuario user = service.getUser(id);
            return ResponseEntity.ok(new API_Response<>(true, "User found successfully", user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<API_Response<List<Usuario>>> getAllUsers() {
        try {
            List<Usuario> users = service.getAllUsers();
            return ResponseEntity.ok(new API_Response<>(true, "Results:", users));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error", null));
        }
    }


    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<API_Response> deleteUser(@PathVariable("id") Long id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.ok(new API_Response(true, "Usuario eliminado", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response(false, "Error: Usuario no encontrado", null));
        }
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<API_Response<Usuario>> updateLibro(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        try {
            Usuario updatedUser = service.updateUser(id, usuario);
            return ResponseEntity.ok(new API_Response<>(true, "Usuario actualizado", updatedUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error: Usuario no encontrado", null));
        }
    }

    @PostMapping("/saveCar")
    public ResponseEntity<API_Response<Coche>> saveCar(@RequestBody Coche coche) {
        try {
            Coche newCoche = service.saveCar(coche);
            return ResponseEntity.ok(new API_Response<>(true, "Car saved successfully", newCoche));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/getCar/{id}")
    public ResponseEntity<API_Response<Coche>> getCar(@PathVariable("id") Long id) {
        try {
            Coche coche = service.getCar(id);
            return ResponseEntity.ok(new API_Response<>(true, "Car found successfully", coche));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/allCars")
    public ResponseEntity<API_Response<List<Coche>>> getAllCars() {
        try {
            List<Coche> cars = service.getAllCars();
            return ResponseEntity.ok(new API_Response<>(true, "Results:", cars));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error", null));
        }
    }


    @DeleteMapping("deleteCar/{id}")
    public ResponseEntity<API_Response> deleteCar(@PathVariable("id") Long id) {
        try {
            service.deleteCar(id);
            return ResponseEntity.ok(new API_Response(true, "Coche eliminado", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response(false, "Error: Coche no encontrado", null));
        }
    }

    @PutMapping("updateCar/{id}")
    public ResponseEntity<API_Response<Coche>> updateCar(@PathVariable("id") Long id, @RequestBody Coche coche) {
        try {
            Coche updatedCoche = service.updateCar(id, coche);
            return ResponseEntity.ok(new API_Response<>(true, "Coche actualizado", updatedCoche));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error: Coche no encontrado", null));
        }
    }


}