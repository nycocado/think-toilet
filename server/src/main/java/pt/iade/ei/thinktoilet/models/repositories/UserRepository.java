package pt.iade.ei.thinktoilet.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.thinktoilet.models.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT new pt.iade.ei.thinktoilet.models.dtos.UserDTO(u.id, u.name, u.points, u.iconId, u.creationDate) FROM User u")
    Iterable<User> findAllWithoutSensitiveData();
    @Query("SELECT new pt.iade.ei.thinktoilet.models.dtos.UserDTO(u.id, u.name, u.points, u.iconId, u.creationDate) FROM User u WHERE u.id = :id")
    Iterable<User> findByIdWithoutSensitiveData(int id);
    @Query("SELECT new pt.iade.ei.thinktoilet.models.dtos.UserDTO(u.id, u.name, u.points, u.iconId, u.creationDate) FROM User u WHERE u.name = :name")
    Iterable<User> findByNameWithoutSensitiveData(String name);
}