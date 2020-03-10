package com.helloxin.mapper.alocal;

import com.helloxin.model.alocal.KktDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface KktMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int insert(KktDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int insertSelective(@Param("record") KktDO record, @Param("selective") KktDO.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    KktDO selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") KktDO.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    KktDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int updateByPrimaryKeySelective(@Param("record") KktDO record, @Param("selective") KktDO.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int updateByPrimaryKey(KktDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int batchInsert(@Param("list") java.util.List<KktDO> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int batchInsertSelective(@Param("list") java.util.List<KktDO> list, @Param("selective") KktDO.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int upsert(KktDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kkt
     *
     * @mbg.generated Tue Mar 10 14:52:09 CST 2020
     */
    int upsertSelective(@Param("record") KktDO record, @Param("selective") KktDO.Column ... selective);
}