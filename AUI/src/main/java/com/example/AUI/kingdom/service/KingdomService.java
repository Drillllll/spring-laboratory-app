package com.example.AUI.kingdom.service;


import com.example.AUI.kingdom.entity.Kingdom;

public interface KingdomService {
    Iterable<Kingdom> findAll();
    Kingdom save(Kingdom kingdom);
    Kingdom findByName(String name);
    void delete(Kingdom kingdom);
}
