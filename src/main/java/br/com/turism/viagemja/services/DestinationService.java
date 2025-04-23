package br.com.turism.viagemja.services;


import br.com.turism.viagemja.repositories.DestinationRepository;
import br.com.turism.viagemja.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository repository;

    public Destination create(Destination destination) {
        return this.repository.save(destination);
    }

    public Optional<Page<Destination>> listAll(String typePlace,
                                               int rating,
                                               int page,
                                               int quantityPage) {
        return Optional.ofNullable(this.repository.findAll(typePlace, rating, PageRequest.of(page, quantityPage)));
    }

    public Destination update(long id, Destination newData) {
        return this.repository.findById(id).map(result -> {
            result.setPlace(newData.getPlace());
            result.setPhoto(newData.getPhoto());
            result.setTypePlace(newData.getTypePlace());
            result.setTextDescription((newData.getTextDescription()));

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
