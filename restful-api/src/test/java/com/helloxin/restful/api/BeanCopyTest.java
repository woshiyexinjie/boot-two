package com.helloxin.restful.api;

import com.helloxin.restful.api.bo.CarBO;
import com.rits.cloning.Cloner;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Slf4j
public class BeanCopyTest {

    final static public Integer NUM = 10000;

    @Test
    public void beanSpringCopyTest() {
        List<CarBO> list = createData(NUM);
        long start = System.currentTimeMillis();
        for(int i = 0;i< NUM;i++){
            CarBO newCar = new CarBO();
            BeanUtils.copyProperties(list.get(i), newCar);
        }
        log.info("duration={}", System.currentTimeMillis() - start);
    }

    @Test
    public void beanCglibCopyTest() {
        List<CarBO> list = createData(NUM);
        long start = System.currentTimeMillis();
        BeanCopier b = BeanCopier.create(CarBO.class, CarBO.class, false);
        for(int i = 0;i< NUM;i++){
            CarBO newCar = new CarBO();
            b.copy(list.get(i), newCar, null);
        }
        log.info("duration={}", System.currentTimeMillis() - start);
    }

    @Test
    public void beanApacheCopyTest() throws InvocationTargetException, IllegalAccessException {
        List<CarBO> list = createData(NUM);
        long start = System.currentTimeMillis();
        BeanCopier b = BeanCopier.create(CarBO.class, CarBO.class, false);
        for(int i = 0;i< NUM;i++){
            CarBO newCar = new CarBO();
            org.apache.commons.beanutils.BeanUtils.copyProperties(newCar,list.get(i));
        }
        log.info("duration={}", System.currentTimeMillis() - start);
    }

    @Test
    public void beanApachePropertyUtilsCopyTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<CarBO> list = createData(NUM);
        long start = System.currentTimeMillis();
        BeanCopier b = BeanCopier.create(CarBO.class, CarBO.class, false);
        for(int i = 0;i< NUM;i++){
            CarBO newCar = new CarBO();
            PropertyUtils.copyProperties(newCar,list.get(i));
        }
        log.info("duration={}", System.currentTimeMillis() - start);
    }

    @Test
    public void beanRitsCloningTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<CarBO> list = createData(NUM);
        long start = System.currentTimeMillis();
        Cloner cloner = new Cloner();
        for(int i = 0;i< NUM;i++){
            cloner.deepClone(list.get(i));
        }
        log.info("duration={}", System.currentTimeMillis() - start);
    }

    private CarBO createData() {
        return CarBO.builder().make("st").numberOfSeats(12).build();
    }

    private List<CarBO> createData(int num) {
        return IntStream.range(0, num).mapToObj(i -> CarBO.builder().make("st").numberOfSeats(i).build()).collect(Collectors.toList());
    }

}
