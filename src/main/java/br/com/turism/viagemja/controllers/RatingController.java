package br.com.turism.viagemja.controllers;

import br.com.turism.viagemja.models.Rating;
import br.com.turism.viagemja.services.RatingService;
import jakarta.validation.Valid;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="avaliacao")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping()
    public ResponseEntity<Rating> createRating(@Valid @RequestBody Rating rating) {
        Rating ratingData = ratingService.addRating(rating);
        return ResponseEntity.ok(ratingData);
    }

}
