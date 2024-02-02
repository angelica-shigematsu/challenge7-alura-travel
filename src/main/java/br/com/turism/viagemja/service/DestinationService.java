package br.com.turism.viagemja.service;


import br.com.turism.viagemja.repositories.DestinationRepository;
import br.com.turism.viagemja.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository repository;

    public Destination create(Destination destination) {
        return this.repository.save(destination);
    }

    public List<Destination> listAll() {
        return this.repository.findAll();
    }

    public Destination update(long id, Destination newData) {
        return this.repository.findById(id).map(result -> {
            result.setPlace(newData.getPlace());
            result.setPhoto(newData.getPhoto());
            result.setPrice(newData.getPrice());

            return this.repository.save(result);
        }).orElseGet(() -> {
            return this.repository.save(newData);
        });
    }

    public void remove(long id) {
        this.repository.deleteById(id);
    }

    public Destination getByPlace(String name) {
        return this.repository.findByPlace(name);
    }
}
