package com.example.AUI.species.repository;

import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.species.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpeciesRepository  extends JpaRepository<Species, UUID> {
    List<Species> findByKingdom(Kingdom kingdom);
    Species findByName(String name);
}
