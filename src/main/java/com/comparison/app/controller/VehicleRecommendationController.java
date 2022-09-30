package com.comparison.app.controller;

import com.comparison.app.entities.VehicleVariant;
import com.comparison.app.model.VehicleVariantRecommendation;
import com.comparison.app.service.RecommendationService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicleRecommendation")
@Slf4j
public class VehicleRecommendationController {

    private static Logger LOGGER = LoggerFactory.getLogger(VehicleRecommendationController.class);

    @Autowired
    private RecommendationService recommendationService;

    @RequestMapping(value = "/{vehicleVariantId}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity saveUser(@PathVariable @NotNull Long vehicleVariantId ){
        LOGGER.info("Request received to get the vehicle suggestions based on the given vehicleVariantId : {}",vehicleVariantId);
        List<VehicleVariant> vehicleVariantList = recommendationService.getAllRecommendedVehicle(vehicleVariantId);
        if(vehicleVariantList != null && vehicleVariantList.size() > 0){
            VehicleVariantRecommendation vehicleVariantRecommendation = new VehicleVariantRecommendation();
            vehicleVariantRecommendation.setVehicleVariantRecommendationList(vehicleVariantList);
            return ResponseEntity.ok().body(vehicleVariantRecommendation);
        }else{
            return ResponseEntity.badRequest().body(null);
        }
    }

}
