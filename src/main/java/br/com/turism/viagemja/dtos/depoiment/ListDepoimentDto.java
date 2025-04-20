package br.com.turism.viagemja.dtos.depoiment;

import br.com.turism.viagemja.models.Rating;

import java.util.List;

public record ListDepoimentDto(
        String fullName,
        String photo,
        boolean permissionListOnDepoiment
) {
}
