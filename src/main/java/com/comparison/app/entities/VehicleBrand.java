package com.comparison.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
// Adding the table name
@Table(name = "vehiclebrand")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brandName;

    @OneToMany(mappedBy = "vehicleBrand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("vehiclebrand")
    private Set<VehicleModel> vehicleModelSet = new HashSet<>();
}
