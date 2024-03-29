package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseResponse;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T17:47:48+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class HouseMapperImpl implements HouseMapper {

    @Override
    public House map(HouseResponse request) {
        if ( request == null ) {
            return null;
        }

        House house = new House();

        house.setLocation( request.getLocation() );
        house.setSize( request.getSize() );
        house.setBedroomsNum( request.getBedroomsNum() );
        house.setBathroomsNum( request.getBathroomsNum() );
        List<Image> list = request.getImage();
        if ( list != null ) {
            house.setImage( new ArrayList<Image>( list ) );
        }
        house.setPrice( request.getPrice() );
        house.setPriceNegotiation( request.isPriceNegotiation() );
        house.setAvailability( request.isAvailability() );
        house.setDescription( request.getDescription() );
        house.setCategories( request.getCategories() );

        return house;
    }

    @Override
    public HouseResponse map(House entity) {
        if ( entity == null ) {
            return null;
        }

        HouseResponse houseResponse = new HouseResponse();

        houseResponse.setLocation( entity.getLocation() );
        houseResponse.setSize( entity.getSize() );
        houseResponse.setBedroomsNum( entity.getBedroomsNum() );
        houseResponse.setBathroomsNum( entity.getBathroomsNum() );
        List<Image> list = entity.getImage();
        if ( list != null ) {
            houseResponse.setImage( new ArrayList<Image>( list ) );
        }
        houseResponse.setPrice( entity.getPrice() );
        houseResponse.setPriceNegotiation( entity.isPriceNegotiation() );
        houseResponse.setAvailability( entity.isAvailability() );
        houseResponse.setDescription( entity.getDescription() );
        houseResponse.setCategories( entity.getCategories() );

        return houseResponse;
    }

    @Override
    public List<HouseResponse> mapList(List<House> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HouseResponse> list = new ArrayList<HouseResponse>( entityList.size() );
        for ( House house : entityList ) {
            list.add( map( house ) );
        }

        return list;
    }
}