package com.example.RentNest.universalHousing;

import com.example.RentNest.universalHousing.dto.UniversalRequest;
import com.example.RentNest.universalHousing.dto.UniversalResponse;
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
public class UniversalMapperImpl implements UniversalMapper {

    @Override
    public UniversalHouse map(UniversalRequest request) {
        if ( request == null ) {
            return null;
        }

        UniversalHouse universalHouse = new UniversalHouse();

        universalHouse.setLocation( request.getLocation() );
        universalHouse.setSize( request.getSize() );
        universalHouse.setBedroomsNum( request.getBedroomsNum() );
        universalHouse.setBathroomsNum( request.getBathroomsNum() );
        universalHouse.setPrice( request.getPrice() );
        universalHouse.setPriceNegotiation( request.isPriceNegotiation() );
        universalHouse.setAvailability( request.isAvailability() );
        universalHouse.setDescription( request.getDescription() );

        return universalHouse;
    }

    @Override
    public UniversalHouse map(UniversalResponse request) {
        if ( request == null ) {
            return null;
        }

        UniversalHouse universalHouse = new UniversalHouse();

        universalHouse.setLocation( request.getLocation() );
        universalHouse.setSize( request.getSize() );
        universalHouse.setBedroomsNum( request.getBedroomsNum() );
        universalHouse.setBathroomsNum( request.getBathroomsNum() );
        universalHouse.setPrice( request.getPrice() );
        universalHouse.setPriceNegotiation( request.isPriceNegotiation() );
        universalHouse.setAvailability( request.isAvailability() );
        universalHouse.setDescription( request.getDescription() );

        return universalHouse;
    }

    @Override
    public UniversalResponse map(UniversalHouse entity) {
        if ( entity == null ) {
            return null;
        }

        UniversalResponse universalResponse = new UniversalResponse();

        universalResponse.setLocation( entity.getLocation() );
        universalResponse.setSize( entity.getSize() );
        universalResponse.setBedroomsNum( entity.getBedroomsNum() );
        universalResponse.setBathroomsNum( entity.getBathroomsNum() );
        universalResponse.setPrice( entity.getPrice() );
        universalResponse.setPriceNegotiation( entity.isPriceNegotiation() );
        universalResponse.setAvailability( entity.isAvailability() );
        universalResponse.setDescription( entity.getDescription() );

        return universalResponse;
    }

    @Override
    public List<UniversalResponse> mapList(List<UniversalHouse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UniversalResponse> list = new ArrayList<UniversalResponse>( entityList.size() );
        for ( UniversalHouse universalHouse : entityList ) {
            list.add( map( universalHouse ) );
        }

        return list;
    }

    @Override
    public void updateEntity(UniversalRequest request, UniversalHouse entity) {
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
