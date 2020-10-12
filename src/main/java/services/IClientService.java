package services;

import javassist.NotFoundException;
import services.models.Client;

import java.util.List;

public interface IClientService {
    List<Client> findAll();

    Client save(Client clientForSave);

    Client getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}

