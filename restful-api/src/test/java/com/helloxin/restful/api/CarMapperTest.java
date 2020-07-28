package com.helloxin.restful.api;

import com.helloxin.restful.api.bo.CarBO;
import com.helloxin.restful.api.dto.CarDTO;
import com.helloxin.restful.api.mapstruct.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CarMapperTest {
    @Test
    public void shouldMapCarToDto() {
        //given
        CarBO car = new CarBO( "Morris", 5);

        //when
        CarDTO carDto = CarMapper.INSTANCE.carToCarDto( car );

        //then
        assertEquals(carDto.getMake(),"Morris" );
    }
}
