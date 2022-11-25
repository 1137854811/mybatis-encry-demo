package com.example.mybatisencrydemo.mapper;


import com.example.mybatisencrydemo.entity.User2;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;


/**
 * (User2)表数据库访问层
 *
 * @author tianzhuang
 * @since 2022-09-09 13:28:28
 */
@Mapper
public interface User2Mapper extends BaseMapper<User2> {


}

