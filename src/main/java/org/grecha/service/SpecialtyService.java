package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;
}
