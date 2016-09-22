package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.pojo.BankRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankRuleMapper {
    int countByExample(BankRuleExample example);

    int deleteByExample(BankRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(BankRule record);

    int insertSelective(BankRule record);

    List<BankRule> selectByExample(BankRuleExample example);

    BankRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BankRule record, @Param("example") BankRuleExample example);

    int updateByExample(@Param("record") BankRule record, @Param("example") BankRuleExample example);

    int updateByPrimaryKeySelective(BankRule record);

    int updateByPrimaryKey(BankRule record);
}