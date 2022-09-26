package com.comparison.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
// Adding the table name
@Table(name = "vehiclemodel",uniqueConstraints={@UniqueConstraint(columnNames = {"modelName" , "vehiclebrand_id"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String modelName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiclebrand_id", referencedColumnName = "id")
    @JsonBackReference
    private VehicleBrand vehicleBrand;

    @OneToMany(mappedBy = "vehicleModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("vehiclemodel")
    private Set<VehicleVariant> vehicleVariantSet = new HashSet<>();
}
