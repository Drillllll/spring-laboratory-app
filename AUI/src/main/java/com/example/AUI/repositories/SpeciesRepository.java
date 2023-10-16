package com.example.AUI.repositories;

import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpeciesRepository  extends JpaRepository<Species, UUID> {
    List<Species> findByKingdom(Kingdom kingdom);
    Species findByName(String name);
}
