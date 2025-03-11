package com.example.Examen_AccesoADatos.Service;

import com.example.Examen_AccesoADatos.Model.Coche;
import com.example.Examen_AccesoADatos.Model.Usuario;
import com.example.Examen_AccesoADatos.Repository.CocheRepository;
import com.example.Examen_AccesoADatos.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CocheRepository cocheRepository;


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


}
