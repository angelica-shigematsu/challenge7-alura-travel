package br.com.turism.viagemja.controllers;

import br.com.turism.viagemja.models.Destination;
import br.com.turism.viagemja.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/destinos")

public class DestinationController {
    @Autowired
    private DestinationService service;

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination place = service.create(destination);

        return new ResponseEntity<>(place, HttpStatus.CREATED);
    }

    @GetMapping(path="/listar")
    public ResponseEntity<List<Destination>> findAllDestionation() {
        List<Destination> place = service.listAll();

        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Destination> updateDestination(@RequestBody Destination destination, @PathVariable int id) {
        Destination place = service.update(id, destination);

        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public void deleteDestination(@PathVariable int id) {
        service.remove(id);
    }

    @GetMapping
    public ResponseEntity<? extends Object> getByDestination(@RequestParam(value="nome") String name) {
        String message = "Nenhum destino foi encontrado";

        Destination place = service.getByPlace(name);

        if (place == null) return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(place, HttpStatus.OK);
    }

}
