package com.example.RentNest.summerHouses;

import com.example.RentNest.summerHouses.dto.SummerRequest;
import com.example.RentNest.summerHouses.dto.SummerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T22:34:17+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class SummerMapperImpl implements SummerMapper {

    @Override
    public SummerHouse map(SummerRequest request) {
        if ( request == null ) {
            return null;
        }

        SummerHouse summerHouse = new SummerHouse();

        summerHouse.setLocation( request.getLocation() );
        summerHouse.setSize( request.getSize() );
        summerHouse.setBedroomsNum( request.getBedroomsNum() );
        summerHouse.setBathroomsNum( request.getBathroomsNum() );
        summerHouse.setPrice( request.getPrice() );
        summerHouse.setPriceNegotiation( request.isPriceNegotiation() );
        summerHouse.setAvailability( request.isAvailability() );
        summerHouse.setDescription( request.getDescription() );

        return summerHouse;
    }

    @Override
    public SummerHouse map(SummerResponse request) {
        if ( request == null ) {
            return null;
        }

        SummerHouse summerHouse = new SummerHouse();

        summerHouse.setLocation( request.getLocation() );
        summerHouse.setSize( request.getSize() );
        summerHouse.setBedroomsNum( request.getBedroomsNum() );
        summerHouse.setBathroomsNum( request.getBathroomsNum() );
        summerHouse.setPrice( request.getPrice() );
        summerHouse.setPriceNegotiation( request.isPriceNegotiation() );
        summerHouse.setAvailability( request.isAvailability() );
        summerHouse.setDescription( request.getDescription() );

        return summerHouse;
    }

    @Override
    public SummerResponse map(SummerHouse entity) {
        if ( entity == null ) {
            return null;
        }

        SummerResponse summerResponse = new SummerResponse();

        summerResponse.setLocation( entity.getLocation() );
        summerResponse.setSize( entity.getSize() );
        summerResponse.setBedroomsNum( entity.getBedroomsNum() );
        summerResponse.setBathroomsNum( entity.getBathroomsNum() );
        summerResponse.setPrice( entity.getPrice() );
        summerResponse.setPriceNegotiation( entity.isPriceNegotiation() );
        summerResponse.setAvailability( entity.isAvailability() );
        summerResponse.setDescription( entity.getDescription() );

        return summerResponse;
    }

    @Override
    public List<SummerResponse> mapList(List<SummerHouse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SummerResponse> list = new ArrayList<SummerResponse>( entityList.size() );
        for ( SummerHouse summerHouse : entityList ) {
            list.add( map( summerHouse ) );
        }

        return list;
    }

    @Override
    public void updateEntity(SummerRequest request, SummerHouse entity) {
        if ( request == null ) {
            return;
        }

        entity.setLocation( request.getLocation() );
        entity.setSize( request.getSize() );
        entity.setBedroomsNum( request.getBedroomsNum() );
        entity.setBathroomsNum( request.getBathroomsNum() );
        entity.setPrice( request.getPrice() );
        entity.setPriceNegotiation( request.isPriceNegotiation() );
        entity.setAvailability( request.isAvailability() );
        entity.setDescription( request.getDescription() );
    }
}
