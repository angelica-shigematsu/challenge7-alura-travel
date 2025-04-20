package br.com.turism.viagemja.services;

import br.com.turism.viagemja.dtos.depoiment.DepoimentDto;
import br.com.turism.viagemja.dtos.depoiment.ListDepoimentDto;
import br.com.turism.viagemja.models.Depoiment;
import br.com.turism.viagemja.repositories.DepoimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepoimentService {
    @Autowired
    private DepoimentRepository repository;
    public ListDepoimentDto create(Depoiment depoiment) {

        Depoiment depoimentData = this.repository.save(depoiment);

        return new ListDepoimentDto(
                depoimentData.getFullName(),
                depoimentData.getPhoto(),
                depoimentData.isAllowListDepoiment());
    }
    public List<Depoiment> listRecentDepoiment() {

        List<Depoiment> depoiment = this.repository.findAll();

        List<Depoiment> showOnlyThreeDepoiment = new ArrayList<>();

        for(Depoiment data: depoiment) {
            if (data.isAllowListDepoiment() && showOnlyThreeDepoiment.size() <= 3) {
                showOnlyThreeDepoiment.add(data);
            }
        }

        if (showOnlyThreeDepoiment != null)
            return showOnlyThreeDepoiment;

        return null;
    }

}
