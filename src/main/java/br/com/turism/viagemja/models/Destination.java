package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3)
    @NotNull(message= "Place is required")
    private String place;

    @Column
    @NotNull(message= "Photo is required")
    private String photo;

    @Column
    @NotNull(message = "Type of place is required")
    private String typePlace;

    @Column
    private String textDescription;

    @OneToMany(mappedBy = "destination")
    private List<Rating> rating;

    @OneToMany(mappedBy = "destination")
    private List<DestinationDetails> destinationDetails;
}
