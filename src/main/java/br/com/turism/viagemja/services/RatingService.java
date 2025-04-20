package br.com.turism.viagemja.services;

import br.com.turism.viagemja.models.Rating;
import br.com.turism.viagemja.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;
    public Rating addRating(Rating rating) {
        return repository.save(rating);
    }
}
