package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.entity.Area;
import org.grecha.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }
}
