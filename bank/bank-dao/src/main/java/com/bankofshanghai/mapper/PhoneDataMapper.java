package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.PhoneData;
import com.bankofshanghai.pojo.PhoneDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneDataMapper {
    int countByExample(PhoneDataExample example);

    int deleteByExample(PhoneDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhoneData record);

    int insertSelective(PhoneData record);

    List<PhoneData> selectByExample(PhoneDataExample example);

    PhoneData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhoneData record, @Param("example") PhoneDataExample example);

    int updateByExample(@Param("record") PhoneData record, @Param("example") PhoneDataExample example);

    int updateByPrimaryKeySelective(PhoneData record);

    int updateByPrimaryKey(PhoneData record);
}