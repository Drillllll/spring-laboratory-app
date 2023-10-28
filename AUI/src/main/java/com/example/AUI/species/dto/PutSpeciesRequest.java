package com.example.AUI.species.dto;

import com.example.AUI.kingdom.entity.Kingdom;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutSpeciesRequest {
    private String name;
    private Integer classificationYear;
    private UUID kingdom;
}
