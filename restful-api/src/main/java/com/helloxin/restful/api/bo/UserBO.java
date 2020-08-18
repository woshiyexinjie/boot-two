package com.helloxin.restful.api.bo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by yebanxian on 2020/8/11.
 */
@Data
@Builder
public class UserBO {
    String userId;
    String userName;
    String userPhone;
    Date createTime;
    Date updateTime;
}
