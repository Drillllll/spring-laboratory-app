package com.example.species.dto;


import com.example.kingdom.dto.GetKingdomResponse;
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
