package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

@Entity()
@Table(name="destination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    private boolean disableView;

    @OneToMany(mappedBy = "destination")
    private List<Rating> rating;

    @OneToMany(mappedBy = "destination")
    private List<DestinationDetails> destinationDetails;

    public Destination(String place, String photo, String typePlace) {
        this.place = place;
        this.photo = photo;
        this.typePlace = typePlace;
    }

    public void updateData(boolean view) {
        this.setDisableView(!view);
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
