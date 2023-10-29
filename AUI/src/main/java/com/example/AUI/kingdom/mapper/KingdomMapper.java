package com.example.AUI.kingdom.mapper;

import com.example.AUI.kingdom.dto.GetKingdomResponse;
import com.example.AUI.kingdom.dto.PostKingdomRequest;
import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;
import org.mapstruct.Mapper;

//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//@Mapper(componentModel = "spring")
@Mapper
public interface KingdomMapper {
    GetKingdomResponse kingdomToGetKingdomResponse(Kingdom kingdom);

    Kingdom putKingdomRequestToKingdom(PutKingdomRequest kingdom);

    Kingdom postKingdomRequestToKingdom(PostKingdomRequest kingdom);
}
