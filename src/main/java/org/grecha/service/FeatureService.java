package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.entity.Feature;
import org.grecha.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeatureService {
    private final FeatureRepository featureRepository;

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature getFeatureByName(String name) {
        return featureRepository.findByName(name);
    }
}
