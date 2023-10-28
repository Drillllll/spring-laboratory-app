package com.example.AUI.kingdom.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetKingdomsResponse {
    private List<GetKingdomResponse> kingdoms;
}
