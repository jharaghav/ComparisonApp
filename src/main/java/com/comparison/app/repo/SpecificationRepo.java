package com.comparison.app.repo;

import com.comparison.app.entities.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepo extends JpaRepository<Specification,Long> {

    @Query(value = "Select * from Specification where vehiclevariant_id = :vehicleVariantId ", nativeQuery = true)
    Specification getSpecificationByVehicleVariant(@Param("vehicleVariantId") Long vehicleVariantId);
}
