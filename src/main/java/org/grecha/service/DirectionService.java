package org.grecha.service;

import lombok.AllArgsConstructor;
import org.grecha.entity.Direction;
import org.grecha.repository.DirectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectionService {
    private final DirectionRepository directionRepository;

    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    public Direction getDirectionsByName(String name) {
        return directionRepository.findByName(name);
    }
}
