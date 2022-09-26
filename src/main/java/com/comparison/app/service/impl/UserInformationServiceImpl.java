package com.comparison.app.service.impl;

import com.comparison.app.entities.UserInformation;
import com.comparison.app.repo.AddressRepo;
import com.comparison.app.repo.UserInformationRepo;
import com.comparison.app.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Optional<UserInformation> saveUserInformation(UserInformation userInformation){

        userInformation.getAddressSet().stream().forEach(address -> address.setUserInformation(userInformation));
        return Optional.of(userInformationRepo.save(userInformation));
    }

    @Override
    public Optional<UserInformation> findUserInformationById(long id){
        return userInformationRepo.findById(id);
    }
}
