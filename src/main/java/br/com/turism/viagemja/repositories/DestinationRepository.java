package br.com.turism.viagemja.repositories;


import br.com.turism.viagemja.models.Destination;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByPlace(String place);

    @Query("""
            SELECT d
            FROM Destination d
            JOIN d.rating r
            WHERE (:typePlace IS NULL OR d.typePlace LIKE :typePlace%)
            AND (:rating IS NULL OR r.rating = :rating)
            """)
    Page<Destination> findAll(@Param("typePlace") String typePlace,
                              @Param("rating") int rating,
                              Pageable page);
}
