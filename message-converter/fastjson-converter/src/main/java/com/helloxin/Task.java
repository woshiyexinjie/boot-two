package com.helloxin;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yebanxian on 2020/4/9.
 */
@Data
@Builder
public class Task {
    private String taskName;
    private Integer cost;
    private Integer days;
}
