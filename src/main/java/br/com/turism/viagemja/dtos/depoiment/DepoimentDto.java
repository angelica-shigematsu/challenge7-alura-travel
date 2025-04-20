package br.com.turism.viagemja.dtos.depoiment;

import br.com.turism.viagemja.models.Rating;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DepoimentDto(
        String fullName,
        String photo,
        boolean permissionListOnDepoiment
) {

}
