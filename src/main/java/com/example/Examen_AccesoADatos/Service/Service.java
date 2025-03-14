package com.example.Examen_AccesoADatos.Service;

import com.example.Examen_AccesoADatos.Model.Alquiler;
import com.example.Examen_AccesoADatos.Model.Coche;
import com.example.Examen_AccesoADatos.Model.Usuario;
import com.example.Examen_AccesoADatos.Repository.AlquilerRepository;
import com.example.Examen_AccesoADatos.Repository.CocheRepository;
import com.example.Examen_AccesoADatos.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CocheRepository cocheRepository;

    @Autowired
    AlquilerRepository alquilerRepository;


    public Usuario saveUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public Usuario getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Usuario updateUser(Long id, Usuario usuario) {
        try {
            Usuario usuarioToUpdate = userRepository.findById(id).orElse(null);
            if (usuarioToUpdate != null) {
                usuarioToUpdate.setUsername(usuario.getUsername());
                usuarioToUpdate.setEmail(usuario.getEmail());
                usuarioToUpdate.setLicenseNumber(usuario.getLicenseNumber());

                //Guarda los cambios
                return userRepository.save(usuarioToUpdate);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Coche saveCar(Coche coche) {
        return cocheRepository.save(coche);
    }

    public Coche getCar(Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    public List<Coche> getAllCars() {
        return cocheRepository.findAll();
    }

    public void deleteCar(Long id) {
        cocheRepository.deleteById(id);
    }

    public Coche updateCar(Long id, Coche coche) {
        try {
            Coche cocheToUpdate = cocheRepository.findById(id).orElse(null);
            if (cocheToUpdate != null) {
                cocheToUpdate.setModel(coche.getModel());
                cocheToUpdate.setBrand(coche.getBrand());
                cocheToUpdate.setPlateNumber(coche.getPlateNumber());
                cocheToUpdate.setAvailable(coche.getAvailable());
                cocheToUpdate.setYear(coche.getYear());

                //Guarda los cambios
                return cocheRepository.save(cocheToUpdate);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Coche> getCarByBrand(String brand) {
        return cocheRepository.findByBrand(brand);
    }

    public List<Coche> getAvailableCars() {
        return cocheRepository.findByAvailable(true);
    }



    public Alquiler saveAlquiler(Alquiler alquiler) {
        Coche coche = cocheRepository.findById(alquiler.getCarId().getId()).orElse(null);
        if (coche.getAvailable()) {
            coche.setAvailable(false);
            cocheRepository.save(coche);
            return alquilerRepository.save(alquiler);
        } else {
            return null;
        }

    }

    public Alquiler returnAlquiler(Long id) {
        Alquiler alquiler = alquilerRepository.findById(id).orElse(null);
        if (alquiler != null) {
            Coche coche = cocheRepository.findById(alquiler.getCarId().getId()).orElse(null);
            coche.setAvailable(true);
            cocheRepository.save(coche);
            alquilerRepository.delete(alquiler);
            return alquiler;
        } else {
            return null;
        }
    }

}
