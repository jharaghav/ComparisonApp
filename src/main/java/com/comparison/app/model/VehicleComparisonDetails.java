package com.comparison.app.model;

import com.comparison.app.entities.Feature;
import com.comparison.app.entities.Specification;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleComparisonDetails implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long vehicleVariantId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Specification specification;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Feature feature;


}
