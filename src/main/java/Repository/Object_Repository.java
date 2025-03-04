package Repository;

import Model.MyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Object_Repository extends JpaRepository<MyObject, Long> {

}
