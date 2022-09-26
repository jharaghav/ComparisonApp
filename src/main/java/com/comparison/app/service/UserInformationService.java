package com.comparison.app.service;

import com.comparison.app.entities.UserInformation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserInformationService {

    public Optional<UserInformation> saveUserInformation(UserInformation userInformation);

    public Optional<UserInformation> findUserInformationById(long id);
}
