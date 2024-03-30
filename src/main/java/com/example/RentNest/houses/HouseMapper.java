package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseRequest;
import com.example.RentNest.houses.dto.HouseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    House map(HouseRequest request);

    HouseResponse map(House entity);

    List<HouseResponse> mapList(List<House> entityList);

    @Mapping(target = "houseId", ignore = true)
    void updateEntity(HouseRequest request,@MappingTarget House entity);
}
