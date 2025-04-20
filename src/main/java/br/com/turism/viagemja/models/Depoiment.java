package br.com.turism.viagemja.models;

import br.com.turism.viagemja.dtos.depoiment.DepoimentDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column
    @Size(min = 3)
    @NotNull(message= "Name is required")
    private String fullName;

    @Column
    private String photo;

    @Column
    @NotNull(message= "Permisson to show your depoiment")
    private boolean allowListDepoiment;

    @OneToOne(mappedBy = "depoiment")
    private Rating rating;

    public Depoiment(DepoimentDto depoimentDto) {
        this.fullName = depoimentDto.fullName();
        this.photo = depoimentDto.photo();
        this.allowListDepoiment = depoimentDto.permissionListOnDepoiment();
    }
}
