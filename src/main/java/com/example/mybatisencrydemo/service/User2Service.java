package com.example.mybatisencrydemo.service;

import com.example.mybatisencrydemo.entity.User2;

import java.util.List;

/**
 * (User2)表服务接口
 *
 * @author tianzhuang
 * @since 2022-09-09 13:28:30
 */
public interface User2Service {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User2 queryById(Long id);

    /**
     * 新增数据
     *
     * @param user2 实例对象
     * @return 实例对象
     */
    void insert(User2 user2);

    /**
     * 修改数据
     *
     * @param user2 实例对象
     * @return 实例对象
     */
    void update(User2 user2);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Long id);

    List<User2> queryList();
}
