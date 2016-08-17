package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankDataMapper {
    int countByExample(BankDataExample example);

    int deleteByExample(BankDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BankData record);

    int insertSelective(BankData record);

    List<BankData> selectByExample(BankDataExample example);

    BankData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BankData record, @Param("example") BankDataExample example);

    int updateByExample(@Param("record") BankData record, @Param("example") BankDataExample example);

    int updateByPrimaryKeySelective(BankData record);

    int updateByPrimaryKey(BankData record);
}