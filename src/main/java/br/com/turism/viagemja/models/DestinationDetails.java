package br.com.turism.viagemja.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity()
@Table(name="destination_details")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class DestinationDetails {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message="Budget is required")
    private double budgetPerPerson;

    @Column
    @NotNull(message="Date valid is required")
    private Date dateValid;

    @ManyToOne
    @JoinColumn(name="destination_id", nullable = false)
    private Destination destination;
}
