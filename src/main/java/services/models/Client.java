package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "clients")

public class Client {
    @Id
    private String client_id;
    private String name;
    private String surname;
    private double temperature;

    public Client(String name,
                  String surname,
                  double temperature) {
        this.name = name;
        this.surname = surname;
        this.temperature = temperature;
        this.client_id = UUID.randomUUID().toString();
    }

    public Client() {

    }

    public String getClient_id() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getTemperature() {
        return temperature;
    }

}
