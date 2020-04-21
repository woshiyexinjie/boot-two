package com.helloxin.common;

public enum PolicyType {
    GRANT("grant", "p", "授权"),
    USER_BIND_GROUP("userBindGroup", "g", "用户绑定组"),
    RESOURCE_BIND_GROUP("resourceBindGroup", "g2", "资源绑定组");

    public String name;
    public String type;
    public String desc;

    private PolicyType(String name, String type, String desc) {
        this.name = name;
        this.type = type;
        this.desc = desc;
    }
}
