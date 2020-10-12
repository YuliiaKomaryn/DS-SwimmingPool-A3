package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

}