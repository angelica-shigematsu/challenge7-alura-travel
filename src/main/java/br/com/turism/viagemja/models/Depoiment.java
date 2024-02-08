package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name="depoiments")
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
    private String depoimentText;

    @Column
    private String photo;

    @Column
    private boolean permissionListOnDepoiment;
}
