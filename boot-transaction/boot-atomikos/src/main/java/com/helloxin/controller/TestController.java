package com.helloxin.controller;

import com.helloxin.mapper.alocal.KktMapper;
import com.helloxin.mapper.local.PpkMapper;
import com.helloxin.model.alocal.KktDO;
import com.helloxin.model.local.PpkDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private PpkMapper ppkMapper;
    @Autowired
    private KktMapper kktMapper;

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Integer setInvalidData() {
        log.info("test");
        PpkDO ppkDO = ppkMapper.selectByPrimaryKey(1);
        log.info(ppkDO.getMsg());

        KktDO kktDO = kktMapper.selectByPrimaryKey(1);
        log.info(kktDO.getTest());
        return 200;

    }
}
