package Service;

import Model.API_Response;
import Repository.Object_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Object_Service {

    @Autowired
    Object_Repository objectRepository;

    public Object save(Object object) {
        return objectRepository.save(object);
    }

    public List<Object> getAllObjects() {
        return objectRepository.findAll();
    }
    }
