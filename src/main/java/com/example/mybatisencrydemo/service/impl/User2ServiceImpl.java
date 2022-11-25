package com.example.mybatisencrydemo.service.impl;

import com.example.mybatisencrydemo.entity.User2;
import com.example.mybatisencrydemo.mapper.User2Mapper;
import com.example.mybatisencrydemo.service.User2Service;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * (User2)表服务实现类
 *
 * @author tianzhuang
 * @since 2022-09-09 13:28:31
 */
@Service("user2Service")
public class User2ServiceImpl implements User2Service {
    @Resource
    private User2Mapper user2Mapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User2 queryById(Long id) {
        return this.user2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User2> queryList() {
        return this.user2Mapper.selectAll();
    }

    /**
     * 新增数据
     *
     * @param user2 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(User2 user2) {
        this.user2Mapper.insert(user2);
    }

    /**
     * 修改数据
     *
     * @param user2 实例对象
     * @return 实例对象
     */
    @Override
    public void update(User2 user2) {
        this.user2Mapper.updateByPrimaryKey(user2);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Long id) {
        this.user2Mapper.deleteByPrimaryKey(id);
    }
}
