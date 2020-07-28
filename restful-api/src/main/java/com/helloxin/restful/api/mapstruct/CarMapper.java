package com.helloxin.restful.api.mapstruct;

import com.helloxin.restful.api.bo.CarBO;
import com.helloxin.restful.api.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

//    @Mapping(source = "seatCount", target = "seatCount")
    CarDTO carToCarDto(CarBO car);
}
