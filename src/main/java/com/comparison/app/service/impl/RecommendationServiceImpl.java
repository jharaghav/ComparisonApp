package com.comparison.app.service.impl;

import com.comparison.app.entities.Feature;
import com.comparison.app.entities.Specification;
import com.comparison.app.entities.VehicleVariant;
import com.comparison.app.repo.FeatureRepo;
import com.comparison.app.repo.SpecificationRepo;
import com.comparison.app.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private SpecificationRepo specificationRepo;

    @Autowired
    private FeatureRepo featureRepo;

    @Value("${vehicle.suggestion.count}")
    private int suggestionCount;

    @Override
    public List<VehicleVariant> getAllRecommendedVehicle(Long vehicleVariantId){
        Map<VehicleVariant,Integer> map = new HashMap<>();
        List<VehicleVariant> vehicleVariantList = new ArrayList<>();

        Specification specification = specificationRepo.getSpecificationByVehicleVariant(vehicleVariantId);
        if(specification == null){
            return vehicleVariantList;
        }

        Feature feature = featureRepo.getFeatureByVehicleVariant(vehicleVariantId);

        List<Specification> specificationList = specificationRepo.findAll();

        List<Feature> featureList = featureRepo.findAll();


        traverseSpecificationList(specificationList,specification,map);

        traverseFeatureList(featureList,feature,map);

        // Create a list from elements of HashMap
        List<Map.Entry<VehicleVariant, Integer> > list
                = new ArrayList(
                map.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i2.getValue().compareTo(i1.getValue()));


        int count = 0;
        for(Map.Entry<VehicleVariant, Integer> aa : list){
            vehicleVariantList.add(aa.getKey());
            count++;
            if(count == suggestionCount) break;
        }

        return vehicleVariantList;
    }

    private void traverseSpecificationList(List<Specification> specificationList,Specification specification,Map<VehicleVariant,Integer> map){

        specificationList.stream().forEach(specification1 -> {
            if(specification.getId() != specification1.getId()){
                if(specification.getBootCapacity() == specification1.getBootCapacity())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getHeightInMM() == specification1.getHeightInMM())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getEngineInstallation().equalsIgnoreCase(specification1.getEngineInstallation()) )
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getEngineType().equalsIgnoreCase(specification1.getEngineType()))
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getKerbWeight() == specification1.getKerbWeight())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getFuelTypePropulsion().equalsIgnoreCase(specification1.getFuelTypePropulsion()))
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getLengthInMM() == specification1.getLengthInMM())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getPrice() == specification1.getPrice())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getMaxEnginePower().equalsIgnoreCase(specification1.getMaxEnginePower()))
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getMaxEngineTorque().equalsIgnoreCase(specification1.getMaxEngineTorque()))
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getWidthInMM() == specification1.getWidthInMM())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
                if(specification.getWheelBaseInMM() == specification1.getWheelBaseInMM())
                    map.put(specification1.getVehicleVariant(),map.getOrDefault(specification1.getVehicleVariant(),0)+1);
            }
        });
    }

    private void traverseFeatureList(List<Feature> featureList,Feature feature,Map<VehicleVariant,Integer> map){
        featureList.stream().forEach(feature1 -> {
            if(feature.getId() != feature1.getId()){
                if(feature.getAntiLockBrakeAbs() == feature1.getAntiLockBrakeAbs())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getAirbags() == feature1.getAirbags())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getDriversSeatMemory().equalsIgnoreCase(feature1.getDriversSeatMemory()))
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getElectronicParkingBay() == feature1.getElectronicParkingBay())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getElectronicBrakeforceDistribution() == feature1.getElectronicBrakeforceDistribution())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getHeadlightType().equalsIgnoreCase(feature1.getHeadlightType()))
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getMassageSeats() == feature1.getMassageSeats())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getFrontFogLamps() == feature1.getFrontFogLamps())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getParkingCamera().equalsIgnoreCase(feature1.getParkingCamera()))
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getParkingSensors().equalsIgnoreCase(feature1.getParkingSensors()))
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getProjectorHeadlamps() == feature1.getProjectorHeadlamps())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getTractionControl() == feature1.getTractionControl())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getVentilatedSeats() == feature1.getVentilatedSeats())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getElectronicStabilityControl() == feature1.getElectronicStabilityControl())
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);
                if(feature.getParkingCamera().equalsIgnoreCase(feature1.getParkingCamera()))
                    map.put(feature1.getVehicleVariant(),map.getOrDefault(feature1.getVehicleVariant(),0)+1);

            }
        });
    }
}
