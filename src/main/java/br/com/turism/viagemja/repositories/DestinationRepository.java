package br.com.turism.viagemja.repositories;


import br.com.turism.viagemja.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByPlace(String place);
}
