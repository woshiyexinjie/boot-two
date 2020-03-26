package com.helloxin;

import lombok.Data;

import java.util.Date;

/**
 * Created by yebanxian on 2020/3/23.
 */
@Data
public class Report {
    private String name;
    private Integer age;
    private String desc;
    private Integer pay;
    private Date createTime;
}
