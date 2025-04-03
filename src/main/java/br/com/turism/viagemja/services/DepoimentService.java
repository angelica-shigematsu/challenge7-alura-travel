package br.com.turism.viagemja.services;

import br.com.turism.viagemja.models.Depoiment;
import br.com.turism.viagemja.repositories.DepoimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepoimentService {
    @Autowired
    DepoimentRepository repository;
    public Depoiment create(Depoiment depoiment) {
        return this.repository.save(depoiment);
    }
    public List<Depoiment> listRecentDepoiment() {

        List<Depoiment> depoiment = this.repository.findAll();

        List<Depoiment> showOnlyThreeDepoiment = new ArrayList<>();

        for(Depoiment data: depoiment) {
            if (data.isPermissionListOnDepoiment() && showOnlyThreeDepoiment.size() <= 3) {
                showOnlyThreeDepoiment.add(data);
            }
        }

        if (showOnlyThreeDepoiment != null)
            return showOnlyThreeDepoiment;

        return null;
    }

}
