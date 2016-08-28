package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.IpAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpAddressMapper {
    int countByExample(IpAddressExample example);

    int deleteByExample(IpAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IpAddress record);

    int insertSelective(IpAddress record);

    List<IpAddress> selectByExample(IpAddressExample example);

    IpAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IpAddress record, @Param("example") IpAddressExample example);

    int updateByExample(@Param("record") IpAddress record, @Param("example") IpAddressExample example);

    int updateByPrimaryKeySelective(IpAddress record);

    int updateByPrimaryKey(IpAddress record);
}