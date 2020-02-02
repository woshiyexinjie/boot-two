package com.helloxin.es.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsInfo implements Serializable {
    private String name;
    private String description;
    private Date uptime;
}
