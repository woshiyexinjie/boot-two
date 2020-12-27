package com.helloxin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 行键
     */
    private String row;

    /**
     * 用户基础信息
     */
    private BaseInfo baseInfo;

    /**
     * 用户其他信息
     */
    private OtherInfo otherInfo;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo{
        /**
         * 名称
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;

        /**
         * 性别
         */
        private String sex;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo{
        /**
         * 电话
         */
        private String phone;
        /**
         * 地址
         */
        private String address;
    }

}
