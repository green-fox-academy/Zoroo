package com.greenfox.zoroo.Repository;

import com.greenfox.zoroo.model.UserProfile;
import com.greenfox.zoroo.model.dto.LoginFormDto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserProfile, Long> {

  List<UserProfile> findAll();
  boolean existsByUsername(String username);
  boolean existsByPassword(String password);
  UserProfile findByUsername(String username);
}
