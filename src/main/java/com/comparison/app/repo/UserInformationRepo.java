package com.comparison.app.repo;

import com.comparison.app.entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepo extends JpaRepository<UserInformation, Long> {
}
