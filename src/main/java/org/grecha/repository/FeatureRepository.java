package org.grecha.repository;

import org.grecha.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    List<Feature> findAll();

    Feature findByName(String name);
}
