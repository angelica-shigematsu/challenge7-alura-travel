package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name="rating")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name="destination_id")
    @NotNull(message = "Id from destination cannot be null")
    private Destination destination;

    @OneToOne
    @JoinColumn(name="depoiment_id")
    @NotNull(message = "Id from depoiment cannot be null")
    private Depoiment depoiment;

    @Column
    private String depoimentText;

    @Column
    @NotNull(message = "Rating cannot be null. Choose number between 1 and 5")
    private int rating;

}
