package br.com.turism.viagemja.controllers;

import br.com.turism.viagemja.dtos.depoiment.DepoimentDto;
import br.com.turism.viagemja.dtos.depoiment.ListDepoimentDto;
import br.com.turism.viagemja.models.Depoiment;
import br.com.turism.viagemja.services.DepoimentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/depoimentos")
public class DepoimentController {

    @Autowired
    private DepoimentService service;
    @PostMapping()
    public ResponseEntity<ListDepoimentDto> createDepoiment(@Valid @RequestBody DepoimentDto depoimentDto) {
        ListDepoimentDto data = service.create(new Depoiment(depoimentDto));

        return ResponseEntity.ok(data);
    }

    @GetMapping()
    public ResponseEntity<List<Depoiment>> listDepoiment() {
        List<Depoiment> data = service.listRecentDepoiment();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
