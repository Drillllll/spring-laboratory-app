package com.example.AUI.species.dto;

import com.example.AUI.kingdom.dto.GetKingdomResponse;
import com.example.AUI.kingdom.entity.Kingdom;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSpeciesResponse {
    private UUID id;
    private String name;
    private Integer classificationYear;
    private GetKingdomResponse kingdom;
}
