package com.example.AUI.repositories;

import com.example.AUI.domain.Kingdom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends CrudRepository<Kingdom, String> {
}
