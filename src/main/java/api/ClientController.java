package api;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IClientService;
import services.models.Client;
import swimmingpool.clientserver.ClientserverApplication;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class ClientController {
    static final Logger log = LoggerFactory.getLogger(ClientserverApplication.class);

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> index() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientPayload payload) {
        System.out.println("ке2;kxfjgn'fjgn'gn'so[r\n");
        Client newClient = new Client(payload.getName(),
                payload.getSurname(),
                payload.getTemperature());
        return ResponseEntity.ok(clientService.save(newClient));
    }


    @GetMapping("{clientId}")
    public ResponseEntity<Client> show(@PathVariable String clientId) throws NotFoundException {
        return ResponseEntity.ok(clientService.getById(clientId));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@PathVariable String clientId) throws NotFoundException {
        clientService.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}