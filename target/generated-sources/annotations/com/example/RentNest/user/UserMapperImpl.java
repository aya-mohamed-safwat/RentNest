package com.example.RentNest.user;

import com.example.RentNest.user.dto.UserResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-30T02:26:52+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(UserResponse request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setName( request.getName() );
        user.setEmail( request.getEmail() );
        user.setNumber( request.getNumber() );
        user.setNationalId( request.getNationalId() );

        return user;
    }

    @Override
    public UserResponse map(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setName( entity.getName() );
        userResponse.setEmail( entity.getEmail() );
        userResponse.setNumber( entity.getNumber() );
        userResponse.setNationalId( entity.getNationalId() );

        return userResponse;
    }

    @Override
    public List<UserResponse> mapList(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( entityList.size() );
        for ( User user : entityList ) {
            list.add( map( user ) );
        }

        return list;
    }
}
