package com.example.kingdom.mapper;



import com.example.kingdom.dto.GetKingdomResponse;
import com.example.kingdom.dto.PostKingdomRequest;
import com.example.kingdom.dto.PutKingdomRequest;
import com.example.kingdom.entity.Kingdom;
import org.mapstruct.Mapper;

//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//@Mapper(componentModel = "spring")
@Mapper
public interface KingdomMapper {
    GetKingdomResponse kingdomToGetKingdomResponse(Kingdom kingdom);

    Kingdom putKingdomRequestToKingdom(PutKingdomRequest kingdom);

    Kingdom postKingdomRequestToKingdom(PostKingdomRequest kingdom);
}
