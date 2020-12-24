package org.grecha.repository;

import org.grecha.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
    List<Direction> findAll();

    Direction findByName(String name);
}
