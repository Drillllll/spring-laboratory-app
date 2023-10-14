package com.example.AUI.services;


import com.example.AUI.domain.Kingdom;

public interface KingdomService {
    Iterable<Kingdom> findAll();
    Kingdom save(Kingdom kingdom);
    Kingdom findByName(String name);
    void delete(Kingdom kingdom);
}
