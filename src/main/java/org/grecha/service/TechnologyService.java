package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TechnologyService {
    private final TechnologyRepository technologyRepository;
}
