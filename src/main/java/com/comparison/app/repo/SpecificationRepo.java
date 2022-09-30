package com.comparison.app.repo;

import com.comparison.app.entities.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepo extends JpaRepository<Specification,Long> {

    @Query(value = "Select * from Specification where vehiclevariant_id = :vehicleVariantId ", nativeQuery = true)
    Specification getSpecificationByVehicleVariant(@Param("vehicleVariantId") Long vehicleVariantId);

    @Query(value = "Select * from Specification s WHERE (s.vehiclevariant_id = :firstVehicleVariantId) or (s.vehiclevariant_id = :secondVehicleVariantId) or (:thirdVehicleVariantId is not null AND s.vehiclevariant_id = :thirdVehicleVariantId)", nativeQuery = true)
    List<Specification> getSpecifications(@Param("firstVehicleVariantId") Long firstVehicleVariantId, @Param("secondVehicleVariantId") Long secondVehicleVariantId, @Param("thirdVehicleVariantId") Long thirdVehicleVariantId );
}
