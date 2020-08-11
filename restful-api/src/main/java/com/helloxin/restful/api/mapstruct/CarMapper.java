package com.helloxin.restful.api.mapstruct;

import com.helloxin.restful.api.bo.CarBO;
import com.helloxin.restful.api.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(CarBO car);
}
