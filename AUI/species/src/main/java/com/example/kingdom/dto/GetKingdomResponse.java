package com.example.kingdom.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetKingdomResponse {
    private UUID id;
}
