package com.bankofshanghai.mapper;

import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.pojo.DataTriExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataTriMapper {
    int countByExample(DataTriExample example);

    int deleteByExample(DataTriExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataTri record);

    int insertSelective(DataTri record);

    List<DataTri> selectByExample(DataTriExample example);

    DataTri selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DataTri record, @Param("example") DataTriExample example);

    int updateByExample(@Param("record") DataTri record, @Param("example") DataTriExample example);

    int updateByPrimaryKeySelective(DataTri record);

    int updateByPrimaryKey(DataTri record);
}