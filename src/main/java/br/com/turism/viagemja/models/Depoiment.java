package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity()
@Table(name="depoiment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Depoiment {
    @Id
    @Column(name="id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String fullName;

    @Column
    private String photo;

    @Column
    private boolean permissionListOnDepoiment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> rating;
}
