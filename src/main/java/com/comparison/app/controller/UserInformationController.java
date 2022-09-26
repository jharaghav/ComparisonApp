package com.comparison.app.controller;

import com.comparison.app.entities.UserInformation;
import com.comparison.app.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserInformationController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserInformationController.class);

    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping(value = "/saveuser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody UserInformation userInformation){
        LOGGER.info("Request received to save the user information");
        Optional<UserInformation> userInformation1 = userInformationService.saveUserInformation(userInformation);
        if(userInformation1.isPresent()){
            return ResponseEntity.ok().body(userInformation1.get());
        }else{
            return ResponseEntity.unprocessableEntity().body(null);
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUserDetails(@PathVariable Long userId){
        LOGGER.info("Request received to fetch the user information");
        Optional<UserInformation> userInformation1 = userInformationService.findUserInformationById(userId);
        if(userInformation1.isPresent()){
            return ResponseEntity.ok().body(userInformation1);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
