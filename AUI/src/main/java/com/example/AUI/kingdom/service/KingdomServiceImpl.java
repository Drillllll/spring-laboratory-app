package com.example.AUI.kingdom.service;

import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.kingdom.repository.KingdomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KingdomServiceImpl implements KingdomService {
    private final KingdomRepository kingdomRepository;

    public KingdomServiceImpl(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }

    @Override
    public List<Kingdom> findAll() {
        return kingdomRepository.findAll();
    }

    @Override
    public Kingdom save(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }

    @Override
    public Kingdom findByName(String name) {
        return kingdomRepository.findByName(name);
    }

    @Override
    public Optional<Kingdom> getKingdomById(UUID id) {
        return kingdomRepository.findById(id);
    }

    @Override
    public void delete(Kingdom kingdom) {
        if (kingdom != null) {
            kingdomRepository.delete(kingdom);
        }
    }

    @Override
    public void updateKingdomById(UUID kingdomId, Kingdom kingdom) {
        kingdom.setId(kingdomId);
        kingdomRepository.save(kingdom);
    }


}
