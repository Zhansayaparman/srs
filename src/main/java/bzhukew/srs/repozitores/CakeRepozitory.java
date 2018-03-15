package bzhukew.srs.repozitores;

import models.Cakes;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CakeRepozitory extends CrudRepository<Cakes,Long> {
    Optional<Cakes> findById(Long id);

}
