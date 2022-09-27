package com.comparison.app.model;

import com.comparison.app.entities.Specification;
import com.comparison.app.entities.VehicleVariant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleVariantRecommendation implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<VehicleVariant> vehicleVariantRecommendationList;
}
