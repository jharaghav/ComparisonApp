package com.comparison.app.service;

import com.comparison.app.model.VehicleComparisonDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleComparisonService {

    public List<VehicleComparisonDetails> getAllComparedData(Long firstVehicleVariantId, Long secondVehicleVariantId, Long thirdVehicleVariantId);

    public VehicleComparisonDetails getOnlyDifferentData(Long vehicleVariantId,VehicleComparisonDetails givenVehicleComparisonDetails);
}
