package com.comparison.app.repo;

import com.comparison.app.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepo extends JpaRepository<Feature,Long> {
    @Query(value = "Select * from Feature where vehiclevariant_id = :vehicleVariantId ", nativeQuery = true)
    Feature getFeatureByVehicleVariant(@Param("vehicleVariantId") Long vehicleVariantId);


    @Query(value = "Select * from Feature f WHERE (:firstVehicleVariantId is null or f.vehiclevariant_id = :firstVehicleVariantId ) or (:secondVehicleVariantId is null or f.vehiclevariant_id = :secondVehicleVariantId ) or (:thirdVehicleVariantId is null or f.vehiclevariant_id = :thirdVehicleVariantId )", nativeQuery = true)
    List<Feature> getFeatures(@Param("firstVehicleVariantId") Long firstVehicleVariantId, @Param("secondVehicleVariantId") Long secondVehicleVariantId, @Param("thirdVehicleVariantId") Long thirdVehicleVariantId);
}
