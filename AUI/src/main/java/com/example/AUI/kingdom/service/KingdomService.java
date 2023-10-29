package com.example.AUI.kingdom.service;


import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KingdomService {
    List<Kingdom> findAll();
    Kingdom save(Kingdom kingdom);
    Kingdom findByName(String name);
    Optional<Kingdom> getKingdomById(UUID id);
    void delete(Kingdom kingdom);

    void updateKingdomById(UUID kingdomId, Kingdom kingdom);
}
