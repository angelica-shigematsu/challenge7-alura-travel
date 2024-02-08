package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name="destinations")
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
    private String textDescription;
}
