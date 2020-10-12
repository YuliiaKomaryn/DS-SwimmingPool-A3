package services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.models.Client;
import services.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Client save(Client clientForSave) {
        return repository.save(clientForSave);
    }

    @Override
    public Client getById(String id) throws NotFoundException {
        Optional<Client> tempClient = repository.findById(id);
        if (tempClient.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Client with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}