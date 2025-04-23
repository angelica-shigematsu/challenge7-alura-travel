package br.com.turism.viagemja.controllers;

import br.com.turism.viagemja.models.Destination;
import br.com.turism.viagemja.services.CreateTextDescriptionOpenAI;
import br.com.turism.viagemja.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/destinos")

public class DestinationController {
    @Autowired
    private DestinationService service;

    private CreateTextDescriptionOpenAI openAI;

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {

        destination.setTextDescription(openAI.showTextDescription((destination.getPlace())));

        Destination place = service.create(destination);

        return ResponseEntity.ok(destination);
    }

    @GetMapping(path="/listar")
    public ResponseEntity<List<Optional<Page<Destination>>>> findAllDestionation(@RequestBody String typePlace,
                                                                                 @RequestBody int rating,
                                                                                 @RequestParam int page,
                                                                                 @RequestParam int quantityPlaces) {

        Optional<Page<Destination>> place = this.service.listAll(typePlace, rating, page, quantityPlaces);

       return ResponseEntity.ok(Collections.singletonList(place));

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
