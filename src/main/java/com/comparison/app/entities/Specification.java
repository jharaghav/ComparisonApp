package com.comparison.app.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
// Adding the table name
@Table(name = "specification",indexes = {
        @Index(name = "price_index", columnList = "price"),
        @Index(name = "bootCapacity_index", columnList = "bootCapacity"),
        @Index(name = "kerbWeight_index", columnList = "kerbWeight"),
        @Index(name = "lengthInMM_index", columnList = "lengthInMM"),
        @Index(name = "widthInMM_index", columnList = "widthInMM"),
        @Index(name = "heightInMM_index", columnList = "heightInMM"),
        @Index(name = "wheelBaseInMM_index", columnList = "wheelBaseInMM"),
        @Index(name = "fuelTypePropulsion_index", columnList = "fuelTypePropulsion"),
        @Index(name = "engineInstallation_index", columnList = "engineInstallation"),
        @Index(name = "engineType_index", columnList = "engineType"),
        @Index(name = "maxEnginePower_index", columnList = "maxEnginePower"),
        @Index(name = "maxEngineTorque_index", columnList = "maxEngineTorque")
}, uniqueConstraints={@UniqueConstraint(columnNames={"vehiclevariant_id"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long bootCapacity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long kerbWeight;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long lengthInMM;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long widthInMM;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long heightInMM;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long wheelBaseInMM;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fuelTypePropulsion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String engineInstallation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String engineType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String maxEnginePower;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String maxEngineTorque;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiclevariant_id", referencedColumnName = "id")
    @JsonBackReference
    private VehicleVariant vehicleVariant;
}
