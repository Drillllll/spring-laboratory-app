package com.example.species.service;


import com.example.kingdom.entity.Kingdom;
import com.example.species.entity.Species;
import com.example.species.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    @Override
    public Species save(Species species) {
        return speciesRepository.save(species);
    }

    @Override
    public List<Species> findByKingdom(Kingdom kingdom) {
        return speciesRepository.findByKingdom(kingdom);
    }

    @Override
    public void delete(Species species) {
        speciesRepository.delete(species);
    }

    @Override
    public Species findByName(String name) {
        return speciesRepository.findByName(name);
    }

    @Override
    public Optional<Species> getSpeciesById(UUID id) {
        return speciesRepository.findById(id);
    }

    @Override
    public void updateSpeciesById(UUID speciesId, Species species) {
        species.setId(speciesId);
        speciesRepository.save(species);
    }
}
