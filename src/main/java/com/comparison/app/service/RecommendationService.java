package com.comparison.app.service;

import com.comparison.app.entities.VehicleVariant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendationService {

    public List<VehicleVariant> getAllRecommendedVehicle(Long vehicleVariantId);
}
