package com.comparison.app.service.impl;

import com.comparison.app.entities.Feature;
import com.comparison.app.entities.Specification;
import com.comparison.app.model.VehicleComparisonDetails;
import com.comparison.app.repo.FeatureRepo;
import com.comparison.app.repo.SpecificationRepo;
import com.comparison.app.service.VehicleComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleComparisonServiceImpl implements VehicleComparisonService {

    @Autowired
    private SpecificationRepo specificationRepo;

    @Autowired
    private FeatureRepo featureRepo;



    @Override
    public List<VehicleComparisonDetails> getAllComparedData(Long firstVehicleVariantId, Long secondVehicleVariantId, Long thirdVehicleVariantId){

        List<VehicleComparisonDetails> vehicleComparisonDetailsList = new ArrayList<>();
        List<Specification> specificationList = specificationRepo.getSpecifications(firstVehicleVariantId,secondVehicleVariantId,thirdVehicleVariantId);

        List <Feature> featureList = featureRepo.getFeatures(firstVehicleVariantId,secondVehicleVariantId,thirdVehicleVariantId);

        for(int i =0 ;i<specificationList.size();i++){
            Specification specification = specificationList.get(i);
            VehicleComparisonDetails vehicleComparisonDetails = new VehicleComparisonDetails();
            vehicleComparisonDetails.setVehicleVariantId(specification.getVehicleVariant().getId());
            vehicleComparisonDetails.setSpecification(specification);
            vehicleComparisonDetails.setFeature(featureList.get(i));
            vehicleComparisonDetailsList.add(vehicleComparisonDetails);
        }

        return vehicleComparisonDetailsList;
    }

    @Override
    public VehicleComparisonDetails getOnlyDifferentData(Long vehicleVariantId,VehicleComparisonDetails givenVehicleComparisonDetails){

        Specification specification = specificationRepo.getSpecificationByVehicleVariant(vehicleVariantId);
        VehicleComparisonDetails vehicleComparisonDetails = new VehicleComparisonDetails();
        Feature feature = featureRepo.getFeatureByVehicleVariant(vehicleVariantId);
        if(specification == null) return vehicleComparisonDetails;

        if(feature == null) return vehicleComparisonDetails;

        vehicleComparisonDetails.setFeature(feature);
        vehicleComparisonDetails.setSpecification(specification);
        vehicleComparisonDetails.setVehicleVariantId(vehicleVariantId);

        if(givenVehicleComparisonDetails == null){
            return vehicleComparisonDetails;

        }else{
            vehicleComparisonDetails = checkDifferentSpecification(givenVehicleComparisonDetails,vehicleComparisonDetails,specification);
            vehicleComparisonDetails = checkDifferentFeature(givenVehicleComparisonDetails,vehicleComparisonDetails,feature);
            return vehicleComparisonDetails;
        }
    }

    private VehicleComparisonDetails checkDifferentSpecification(VehicleComparisonDetails givenVehicleComparisonDetails,VehicleComparisonDetails currentVehicleComparisonDetails, Specification specification){

        if(givenVehicleComparisonDetails.getSpecification().getWheelBaseInMM().equals(specification.getWheelBaseInMM()))
            currentVehicleComparisonDetails.getSpecification().setWheelBaseInMM(null);
        if(givenVehicleComparisonDetails.getSpecification().getPrice().equals(specification.getPrice()))
            currentVehicleComparisonDetails.getSpecification().setPrice(null);
        if(givenVehicleComparisonDetails.getSpecification().getWidthInMM().equals(specification.getWidthInMM()))
            currentVehicleComparisonDetails.getSpecification().setWidthInMM(null);
        if(givenVehicleComparisonDetails.getSpecification().getMaxEngineTorque().equalsIgnoreCase(specification.getMaxEngineTorque()))
            currentVehicleComparisonDetails.getSpecification().setMaxEngineTorque(null);
        if(givenVehicleComparisonDetails.getSpecification().getMaxEnginePower().equalsIgnoreCase(specification.getMaxEnginePower()))
            currentVehicleComparisonDetails.getSpecification().setMaxEnginePower(null);
        if(givenVehicleComparisonDetails.getSpecification().getLengthInMM().equals(specification.getLengthInMM()))
            currentVehicleComparisonDetails.getSpecification().setLengthInMM(null);
        if(givenVehicleComparisonDetails.getSpecification().getFuelTypePropulsion().equalsIgnoreCase(specification.getFuelTypePropulsion()))
            currentVehicleComparisonDetails.getSpecification().setFuelTypePropulsion(null);
        if(givenVehicleComparisonDetails.getSpecification().getKerbWeight().equals(specification.getKerbWeight()))
            currentVehicleComparisonDetails.getSpecification().setKerbWeight(null);
        if(givenVehicleComparisonDetails.getSpecification().getEngineType().equalsIgnoreCase(specification.getEngineType()))
            currentVehicleComparisonDetails.getSpecification().setEngineType(null);
        if(givenVehicleComparisonDetails.getSpecification().getEngineInstallation().equalsIgnoreCase(specification.getEngineInstallation()))
            currentVehicleComparisonDetails.getSpecification().setEngineInstallation(null);
        if(givenVehicleComparisonDetails.getSpecification().getBootCapacity().equals(specification.getBootCapacity()))
            currentVehicleComparisonDetails.getSpecification().setBootCapacity(null);
        if(givenVehicleComparisonDetails.getSpecification().getHeightInMM().equals(specification.getHeightInMM()))
            currentVehicleComparisonDetails.getSpecification().setHeightInMM(null);

        return currentVehicleComparisonDetails;

    }

    private VehicleComparisonDetails checkDifferentFeature(VehicleComparisonDetails givenVehicleComparisonDetails,VehicleComparisonDetails currentVehicleComparisonDetails, Feature feature){

        if(givenVehicleComparisonDetails.getFeature().getElectronicStabilityControl() == feature.getElectronicStabilityControl())
            currentVehicleComparisonDetails.getFeature().setElectronicStabilityControl(null);
        if(givenVehicleComparisonDetails.getFeature().getVentilatedSeats() == feature.getVentilatedSeats())
            currentVehicleComparisonDetails.getFeature().setVentilatedSeats(null);
        if(givenVehicleComparisonDetails.getFeature().getParkingCamera().equalsIgnoreCase(feature.getParkingCamera()))
            currentVehicleComparisonDetails.getFeature().setParkingCamera(null);
        if(givenVehicleComparisonDetails.getFeature().getTractionControl() == feature.getTractionControl())
            currentVehicleComparisonDetails.getFeature().setTractionControl(null);
        if(givenVehicleComparisonDetails.getFeature().getProjectorHeadlamps() == feature.getProjectorHeadlamps())
            currentVehicleComparisonDetails.getFeature().setProjectorHeadlamps(null);
        if(givenVehicleComparisonDetails.getFeature().getParkingSensors().equalsIgnoreCase(feature.getParkingSensors()))
            currentVehicleComparisonDetails.getFeature().setParkingSensors(null);
        if(givenVehicleComparisonDetails.getFeature().getFrontFogLamps() == feature.getFrontFogLamps())
            currentVehicleComparisonDetails.getFeature().setFrontFogLamps(null);
        if(givenVehicleComparisonDetails.getFeature().getMassageSeats() == feature.getMassageSeats())
            currentVehicleComparisonDetails.getFeature().setMassageSeats(null);
        if(givenVehicleComparisonDetails.getFeature().getHeadlightType().equalsIgnoreCase(feature.getHeadlightType()))
            currentVehicleComparisonDetails.getFeature().setHeadlightType(null);
        if(givenVehicleComparisonDetails.getFeature().getAirbags() == feature.getAirbags())
            currentVehicleComparisonDetails.getFeature().setAirbags(null);
        if(givenVehicleComparisonDetails.getFeature().getAntiLockBrakeAbs() == feature.getAntiLockBrakeAbs())
            currentVehicleComparisonDetails.getFeature().setAntiLockBrakeAbs(null);
        if(givenVehicleComparisonDetails.getFeature().getDriversSeatMemory().equalsIgnoreCase(feature.getDriversSeatMemory()))
            currentVehicleComparisonDetails.getFeature().setDriversSeatMemory(null);
        if(givenVehicleComparisonDetails.getFeature().getElectronicBrakeforceDistribution() == feature.getElectronicBrakeforceDistribution())
            currentVehicleComparisonDetails.getFeature().setElectronicBrakeforceDistribution(null);
        if(givenVehicleComparisonDetails.getFeature().getElectronicParkingBay() == feature.getElectronicParkingBay())
            currentVehicleComparisonDetails.getFeature().setElectronicParkingBay(null);
        return currentVehicleComparisonDetails;
    }
}
