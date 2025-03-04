package Controler;

import Model.API_Response;
import Model.MyObject;
import Service.Object_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/examen")
public class Object_Controler {
    private final Object_Service objectService;

    @Autowired
    public Object_Controler(Object_Service objectService) {
        this.objectService = objectService;
    }

    @PostMapping("/save")
    public ResponseEntity <API_Response<MyObject>> save(@RequestBody MyObject object) {
        try {
            MyObject newObject = objectService.save(object);
            return ResponseEntity.ok(new API_Response<>(true, "Object saved successfully", newObject));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<API_Response<List<MyObject>>> getAllObjects() {
        try {
            List<MyObject> objects = objectService.getAllObjects();
            return ResponseEntity.ok(new API_Response<>(true, "Results:", objects));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new API_Response<>(false, "Error", null));
        }
    }
}