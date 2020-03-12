package com.helloxin.service;

import com.helloxin.mapper.alocal.KktMapper;
import com.helloxin.mapper.local.PpkMapper;
import com.helloxin.model.alocal.KktDO;
import com.helloxin.model.local.PpkDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by yebanxian on 2020/3/10.
 */
@Service
@Slf4j
public class TranServiceImpl implements TranService {

    @Autowired
    private PpkMapper ppkMapper;
    @Autowired
    private KktMapper kktMapper;

    @Override
    @Transactional
    public void addTest(){

        PpkDO ppkDO = new PpkDO();
        ppkDO.setMsg("test5");
        ppkMapper.insert(ppkDO);

        KktDO kktDO = new KktDO();
        kktDO.setTest("test2");
        kktMapper.insert(kktDO);
//        throw  new RuntimeException("I am a Monster");
    }

}
