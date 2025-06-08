package br.com.turism.viagemja.dtos.destination;

import br.com.turism.viagemja.models.Rating;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListDestinationDto(
        String place,

        String photo,

        String typePlace,

        String textDescription
){}
