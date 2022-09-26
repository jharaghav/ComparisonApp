package com.comparison.app.repo;

import com.comparison.app.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepo extends JpaRepository<Feature,Long> {
    @Query(value = "Select * from Feature where vehiclevariant_id = :vehicleVariantId ", nativeQuery = true)
    Feature getFeatureByVehicleVariant(@Param("vehicleVariantId") Long vehicleVariantId);
}
