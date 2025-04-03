package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity()
@Table(name="destination")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Destination {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String place;

    @Column
    private String photo;

    @Column
    private double price;

    @Column
    private String typePlace;

    @Column
    private String textDescription;

    @OneToMany(mappedBy = "destination")
    private List<Rating> rating;
}
