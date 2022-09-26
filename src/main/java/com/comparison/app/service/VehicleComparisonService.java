package com.comparison.app.service;

import com.comparison.app.model.VehicleComparisonDetails;
import org.springframework.stereotype.Service;

@Service
public interface VehicleComparisonService {

    public VehicleComparisonDetails getAllComparedData(Long vehicleVariantId);

    public VehicleComparisonDetails getOnlyDifferentData(Long vehicleVariantId,VehicleComparisonDetails givenVehicleComparisonDetails);
}
