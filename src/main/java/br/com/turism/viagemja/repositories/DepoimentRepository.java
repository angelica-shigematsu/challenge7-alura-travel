package br.com.turism.viagemja.repositories;

import br.com.turism.viagemja.models.Depoiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentRepository extends JpaRepository<Depoiment, Long> {

}
