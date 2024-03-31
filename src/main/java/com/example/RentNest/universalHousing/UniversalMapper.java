package com.example.RentNest.universalHousing;

import com.example.RentNest.universalHousing.dto.UniversalRequest;
import com.example.RentNest.universalHousing.dto.UniversalResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversalMapper {

    UniversalMapper INSTANCE = Mappers.getMapper(UniversalMapper.class);

    UniversalHouse map(UniversalRequest request);

    UniversalHouse map(UniversalResponse request);

    UniversalResponse map(UniversalHouse entity);

    List<UniversalResponse> mapList(List<UniversalHouse> entityList);

    @Mapping(target = "universalHouseId", ignore = true)
    void updateEntity(UniversalRequest request,@MappingTarget UniversalHouse entity);
}
