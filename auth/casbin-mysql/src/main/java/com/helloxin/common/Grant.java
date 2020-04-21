package com.helloxin.common;

import lombok.Data;

@Data
public class Grant {
    private String subject;
    private String resource;
    private String privilege;
}
