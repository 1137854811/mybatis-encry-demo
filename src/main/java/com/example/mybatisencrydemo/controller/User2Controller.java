package com.example.mybatisencrydemo.controller;

import com.example.mybatisencrydemo.entity.Result;
import com.example.mybatisencrydemo.entity.User2;
import com.example.mybatisencrydemo.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * (User2)表控制层
 *
 * @author tianzhuang
 * @since 2022-09-09 13:28:27
 */
@RestController
@RequestMapping("user2")
public class User2Controller {
    /**
     * 服务对象
     */
    @Autowired
    private User2Service user2Service;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<User2> queryById(@PathVariable("id") Long id) {
        return Result.success(this.user2Service.queryById(id));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping()
    public Result<User2> queryById() {
        return Result.success(this.user2Service.queryList());
    }

    /**
     * 新增数据
     *
     * @param user2 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(User2 user2) {
        this.user2Service.insert(user2);
        return Result.success();
    }

    /**
     * 编辑数据
     *
     * @param user2 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<User2> edit(User2 user2) {
        this.user2Service.update(user2);
        return Result.success();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        this.user2Service.deleteById(id);
        return Result.success();
    }

}

