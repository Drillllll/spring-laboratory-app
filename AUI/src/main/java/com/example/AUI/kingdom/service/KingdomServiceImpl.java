package com.example.AUI.kingdom.service;

import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.kingdom.repository.KingdomRepository;
import org.springframework.stereotype.Service;

@Service
public class KingdomServiceImpl implements KingdomService {
    private final KingdomRepository kingdomRepository;

    public KingdomServiceImpl(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }

    @Override
    public Iterable<Kingdom> findAll() {
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
    public void delete(Kingdom kingdom) {
        if (kingdom != null) {
            kingdomRepository.delete(kingdom);
        }
    }
}
