package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    House map(HouseResponse request);

    HouseResponse map(House entity);

    List<HouseResponse> mapList(List<House> entityList);
}
