package com.comparison.app.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
// Adding the table name
@Table(name = "feature",indexes = {
        @Index(name = "airbags_index", columnList = "airbags"),
        @Index(name = "antiLockBrakeAbs_index", columnList = "antiLockBrakeAbs"),
        @Index(name = "electronicBrakeforceDistribution_index", columnList = "electronicBrakeforceDistribution"),
        @Index(name = "electronicParkingBay_index", columnList = "electronicParkingBay"),
        @Index(name = "tractionControl_index", columnList = "tractionControl"),
        @Index(name = "electronicStabilityControl_index", columnList = "electronicStabilityControl"),
        @Index(name = "parkingSensors_index", columnList = "parkingSensors"),
        @Index(name = "parkingCamera_index", columnList = "parkingCamera"),
        @Index(name = "headlightType_index", columnList = "headlightType"),
        @Index(name = "projectorHeadlamps_index", columnList = "projectorHeadlamps"),
        @Index(name = "frontFogLamps_index", columnList = "frontFogLamps"),
        @Index(name = "driversSeatMemory_index", columnList = "driversSeatMemory"),
        @Index(name = "ventilatedSeats_index", columnList = "ventilatedSeats"),
        @Index(name = "massageSeats_index", columnList = "massageSeats")
},uniqueConstraints={@UniqueConstraint(columnNames={"vehiclevariant_id"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer airbags;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean antiLockBrakeAbs ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean electronicBrakeforceDistribution;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean electronicParkingBay;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean tractionControl ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean electronicStabilityControl ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parkingSensors ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parkingCamera ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String headlightType ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean projectorHeadlamps ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean frontFogLamps ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String driversSeatMemory ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean ventilatedSeats ;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean massageSeats ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiclevariant_id", referencedColumnName = "id")
    @JsonBackReference
    private VehicleVariant vehicleVariant;
}
