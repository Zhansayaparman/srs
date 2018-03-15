package bzhukew.srs.repozitores;

import models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepozirory extends CrudRepository<Client, Long> {
    Optional<Client> findById(Long id);

}
