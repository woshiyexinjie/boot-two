package com.helloxin.service;

import com.helloxin.common.BindGroup;
import com.helloxin.common.Grant;
import lombok.extern.slf4j.Slf4j;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.helloxin.common.PolicyType.GRANT;
import static com.helloxin.common.PolicyType.USER_BIND_GROUP;
import static com.helloxin.common.PolicyType.RESOURCE_BIND_GROUP;
@Slf4j
@Service
public class AuthService {

    @Autowired
    private Enforcer enforcer;

    public void addPolicy(Grant grant) {
        enforcer.addNamedPolicy(GRANT.type,grant.getSubject(), grant.getResource(),grant.getPrivilege());
    }

    public void addPolicyGUserBind(BindGroup bndGroup) {
        enforcer.addNamedGroupingPolicy(USER_BIND_GROUP.type,bndGroup.getSubject(), bndGroup.getGroup());
    }

    public void addPolicyGResouceBind(BindGroup bndGroup) {
        enforcer.addNamedGroupingPolicy(RESOURCE_BIND_GROUP.type,bndGroup.getSubject(), bndGroup.getGroup());
    }
}
