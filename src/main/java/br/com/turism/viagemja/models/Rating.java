package br.com.turism.viagemja.models;

import jakarta.persistence.*;
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
    private Destination destination;

    @OneToOne
    @JoinColumn(name="depoiment_id")
    private Depoiment depoiment;

    @Column
    private String depoimentText;

    @Column
    private int rating;

}
