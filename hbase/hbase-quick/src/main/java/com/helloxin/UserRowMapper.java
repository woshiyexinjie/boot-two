package com.helloxin;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class UserRowMapper implements RowMapper<User> {

    public static byte[] FAMILY_B="b".getBytes();
    public static byte[] NAME="name".getBytes();
    public static byte[] AGE="age".getBytes();
    public static byte[] SEX="sex".getBytes();

    public static byte[] FAMILY_O="o".getBytes();
    public static byte[] PHONE="phone".getBytes();
    public static byte[] ADDRESS="address".getBytes();

    @Override
    public User mapRow(Result result, int i) throws Exception {
        User.BaseInfo baseInfo=new User.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_B,NAME)),
                Bytes.toInt(result.getValue(FAMILY_B,AGE)),
                Bytes.toString(result.getValue(FAMILY_B,SEX))
        );
        User.OtherInfo otherInfo=new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O,PHONE)),
                Bytes.toString(result.getValue(FAMILY_O,ADDRESS))
        );
        return new User(Bytes.toString(result.getRow()),baseInfo,otherInfo);
    }
}
