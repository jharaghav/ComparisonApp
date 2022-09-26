package com.comparison.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
// Adding the table name
@Table(name = "vehiclevariant",uniqueConstraints={@UniqueConstraint(columnNames = {"variantName" , "vehiclemodel_id"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String variantName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiclemodel_id", referencedColumnName = "id")
    @JsonBackReference
    private VehicleModel vehicleModel;

    @OneToOne(mappedBy = "vehicleVariant")
    private Specification specification;

    @OneToOne(mappedBy = "vehicleVariant")
    private Feature feature;
}
