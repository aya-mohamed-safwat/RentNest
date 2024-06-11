package com.example.RentNest.capital;

import com.example.RentNest.capital.dto.CapitalHouseRequest;
import com.example.RentNest.capital.dto.CapitalHouseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CapitalHouseMapper {
    CapitalHouseMapper INSTANCE = Mappers.getMapper(CapitalHouseMapper.class);

    CapitalHouse map(CapitalHouseRequest request);

    CapitalHouse map(CapitalHouseResponse request);

    CapitalHouseResponse map(CapitalHouse entity);

    List<CapitalHouseResponse> mapList(List<CapitalHouse> entityList);

    @Mapping(target = "capitalHouseId", ignore = true)
    void updateEntity(CapitalHouseRequest request, @MappingTarget CapitalHouse entity);
}
