package com.greenfox.zoroo.Repository;

import com.greenfox.zoroo.model.GeographicInfo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface GeographicInfoRepo extends CrudRepository<GeographicInfo, Long> {

  List<GeographicInfo> findAll();
 }
