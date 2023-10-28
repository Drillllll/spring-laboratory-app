package com.example.AUI.species.dto;

import com.example.AUI.kingdom.entity.Kingdom;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMultipleSpeciesResponse {
    List<GetSpeciesResponse> species;

}
