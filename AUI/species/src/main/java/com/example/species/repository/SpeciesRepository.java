package com.example.species.repository;


import com.example.kingdom.entity.Kingdom;
import com.example.species.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpeciesRepository  extends JpaRepository<Species, UUID> {
    List<Species> findByKingdom(Kingdom kingdom);
    Species findByName(String name);
}
