package com.example.RentNest.summerHouses;

import com.example.RentNest.summerHouses.dto.SummerRequest;
import com.example.RentNest.summerHouses.dto.SummerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SummerMapper {
    SummerMapper INSTANCE = Mappers.getMapper(SummerMapper.class);

    SummerHouse map(SummerRequest request);

    SummerHouse map(SummerResponse request);

    SummerResponse map(SummerHouse entity);

    List<SummerResponse> mapList(List<SummerHouse> entityList);

    @Mapping(target = "summerHouseId", ignore = true)
    void updateEntity(SummerRequest request,@MappingTarget SummerHouse entity);
}
