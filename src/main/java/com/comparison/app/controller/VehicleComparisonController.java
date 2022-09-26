package com.comparison.app.controller;

import com.comparison.app.entities.UserInformation;
import com.comparison.app.model.VehicleComparisonDetails;
import com.comparison.app.service.UserInformationService;
import com.comparison.app.service.VehicleComparisonService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehiclecomparison")
@Slf4j
public class VehicleComparisonController {

    private static Logger LOGGER = LoggerFactory.getLogger(VehicleComparisonController.class);

    @Autowired
    private VehicleComparisonService vehicleComparisonService;

    @RequestMapping(value = "/getAllDetails",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllVehicleDetails(@RequestParam(name = "firstVehicleVariantId") Integer firstVehicleVariantId,
                                   @RequestParam(name = "secondVehicleVariantId") Integer secondVehicleVariantId,
    @RequestParam(required = false,name = "thirdVehicleVariantId") Integer thirdVehicleVariantId){
        LOGGER.info("Request received to see all the feature and specification details");
        if((firstVehicleVariantId <= 0 || secondVehicleVariantId <= 0) && (thirdVehicleVariantId != null && thirdVehicleVariantId <= 0))
            return ResponseEntity.badRequest().body("Please provide valid inputs");

        List<VehicleComparisonDetails> vehicleComparisonDetailsList = new ArrayList<>();

        if(firstVehicleVariantId > 0 )
            vehicleComparisonDetailsList.add(vehicleComparisonService.getAllComparedData(firstVehicleVariantId.longValue()));
        if(secondVehicleVariantId > 0)
            vehicleComparisonDetailsList.add(vehicleComparisonService.getAllComparedData(secondVehicleVariantId.longValue()));
        if(thirdVehicleVariantId != null && thirdVehicleVariantId > 0)
            vehicleComparisonDetailsList.add(vehicleComparisonService.getAllComparedData(thirdVehicleVariantId.longValue()));
        if(vehicleComparisonDetailsList.size() != 0){
            return ResponseEntity.ok().body(vehicleComparisonDetailsList);
        }else{
            return ResponseEntity.badRequest().body("Please provide valid inputs");
        }

    }

    @RequestMapping(value = "/getDifferences",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getVehicleDifferences(@RequestParam(name = "firstVehicleVariantId") Integer firstVehicleVariantId,
                                               @RequestParam(name = "secondVehicleVariantId") Integer secondVehicleVariantId,
                                               @RequestParam(required = false,name = "thirdVehicleVariantId") Integer thirdVehicleVariantId){
        LOGGER.info("Request received to see the feature and specification differences");
        if((firstVehicleVariantId <= 0 || secondVehicleVariantId <= 0) && (thirdVehicleVariantId != null && thirdVehicleVariantId <= 0))
            return ResponseEntity.badRequest().body("Please provide valid inputs");

        List<VehicleComparisonDetails> vehicleComparisonDetailsList = new ArrayList<>();
        VehicleComparisonDetails vehicleComparisonDetails = new VehicleComparisonDetails();

        if(firstVehicleVariantId > 0 )
            vehicleComparisonDetails = vehicleComparisonService.getOnlyDifferentData(firstVehicleVariantId.longValue(),null);
            vehicleComparisonDetailsList.add(vehicleComparisonDetails);
        if(secondVehicleVariantId > 0)
            vehicleComparisonDetailsList.add(vehicleComparisonService.getOnlyDifferentData(secondVehicleVariantId.longValue(),vehicleComparisonDetails));
        if(thirdVehicleVariantId != null && thirdVehicleVariantId > 0)
            vehicleComparisonDetailsList.add(vehicleComparisonService.getOnlyDifferentData(thirdVehicleVariantId.longValue(),vehicleComparisonDetails));

        if(vehicleComparisonDetailsList.size() != 0){
            return ResponseEntity.ok().body(vehicleComparisonDetailsList);
        }else{
            return ResponseEntity.badRequest().body("Please provide valid inputs");
        }

    }

}
