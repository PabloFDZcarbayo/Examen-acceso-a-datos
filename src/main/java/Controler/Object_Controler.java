package Controler;

import Model.API_Response;
import Service.Object_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("api/v1/ExamenAccesoADatos")
public class Object_Controler {
    private final Object_Service objectService;

    public Object_Controler(Object_Service objectService) {
        this.objectService = objectService;
    }

    @PostMapping
    public ResponseEntity<API_Response<Object>> save(@RequestBody Object object) {
        try {
            Object newObject = objectService.save(object);
            return ResponseEntity.ok(new API_Response<>(true, "Object saved successfully", newObject));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping
    public ResponseEntity<API_Response<List<Object>>> getAllObjects() {
        try {
            List<Object> objects = objectService.getAllObjects();
            return ResponseEntity.ok(new API_Response<>(true, "Results:", objects));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error", null));
        }
    }
}