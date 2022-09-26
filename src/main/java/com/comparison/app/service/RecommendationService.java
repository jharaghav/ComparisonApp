package com.comparison.app.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendationService {

    public List<Long> getAllRecommendedVehicle(Long vehicleVariantId);
}
