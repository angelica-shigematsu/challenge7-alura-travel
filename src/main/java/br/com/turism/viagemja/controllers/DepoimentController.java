package br.com.turism.viagemja.controllers;

import br.com.turism.viagemja.models.Depoiment;
import br.com.turism.viagemja.services.DepoimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="depoimentos")
public class DepoimentController {

    @Autowired

    DepoimentService service;
    @PostMapping()
    public ResponseEntity<Depoiment> createDepoiment(@RequestBody Depoiment depoiment) {
        Depoiment data = service.create(depoiment);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Depoiment>> listDepoiment() {
        List<Depoiment> data = service.listRecentDepoiment();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
