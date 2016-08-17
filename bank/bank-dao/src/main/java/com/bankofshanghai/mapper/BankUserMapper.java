package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.BankUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankUserMapper {
    int countByExample(BankUserExample example);

    int deleteByExample(BankUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BankUser record);

    int insertSelective(BankUser record);

    List<BankUser> selectByExample(BankUserExample example);

    BankUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BankUser record, @Param("example") BankUserExample example);

    int updateByExample(@Param("record") BankUser record, @Param("example") BankUserExample example);

    int updateByPrimaryKeySelective(BankUser record);

    int updateByPrimaryKey(BankUser record);
}