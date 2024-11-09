package pt.iade.ei.thinktoilet.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.thinktoilet.models.Interaction;

@Repository
public interface InteractionRepository extends CrudRepository<Interaction, Integer> {

}
