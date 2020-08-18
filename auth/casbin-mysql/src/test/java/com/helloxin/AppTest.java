package com.helloxin;

import com.helloxin.common.Grant;
import com.helloxin.service.AuthService;
import org.casbin.jcasbin.main.Enforcer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
{

    @Autowired
    private Enforcer enforcer;
    @Autowired
    private AuthService authService;

    @Test
    @Transactional
    public void should_add_policy_success() {
        //加上事务处理
        Grant grant = new Grant();
        grant.setSubject("zhagnsan");
        grant.setResource("apple");
        grant.setPrivilege("eat'");
        authService.addPolicy(grant);
    }

    @Test
    @Transactional
    public void should_add_group_policy_success() {
        //加上事务处理
//        Grant grant = new Grant();
//        grant.setSubject("group1");
//        grant.setResource("orange");
//        grant.setPrivilege("eat");
//        authService.addPolicy(grant);
//        BindGroup rBindGroup = new BindGroup();
//        rBindGroup.setGroup("group1");
//        rBindGroup.setSubject("orange");
//        authService.addPolicyGResouceBind(rBindGroup);
//
//        BindGroup oBindGroup = new BindGroup();
//        oBindGroup.setGroup("group1");
//        oBindGroup.setSubject("zhangsan");
//        authService.addPolicyGUserBind(oBindGroup);

        String sub = "zhangsan";
        String obj = "orange";
        String act = "eat";

        if (enforcer.enforce(sub, obj, act) == true) {
            System.out.println("lisi eat mantou");
        } else {
            System.out.println("deny the request, show an error");
        }
        List<List<String>> list = enforcer.getImplicitPermissionsForUser("zhangsan");
        list.stream().forEach(x->x.stream().forEach(y-> System.out.println(y)));
    }


    @Test
    public void should_lisi_eat_mantou_success() {
        String sub = "lisi";
        String obj = "mantou";
        String act = "eat";
        if (enforcer.enforce(sub, obj, act) == true) {
            System.out.println("lisi eat mantou");
        } else {
            System.out.println("deny the request, show an error");
        }
    }

    @Test
    public void should_get_permission_for_user_success(){
        List<List<String>> list = enforcer.getImplicitPermissionsForUser("lisi");
        list.stream().forEach(x->x.stream().forEach(y-> System.out.println(y)));
    }
}
