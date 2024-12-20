package com.project.template.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.SysRole;
import com.project.template.utils.Utils;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author B站：程序员瑞哥
 * 
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController{

    /**
     * 列表
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "")
    @GetMapping("/list")
    public Result<List<SysRole>> list() {
        return new Result<>().success(sysRoleService.list());
    }

    /**
     * 分页查询
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public Result<PageVO<SysRole>> findPage(@RequestParam(defaultValue = "") String name,
                                           @RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        //查出的数据根据id降序排列
        wrapper.orderByDesc(SysRole::getId);
        //且支持用户名称模糊查询
        wrapper.like(StringUtils.isNotBlank(name), SysRole::getName, name);
        Page<SysRole> page = sysRoleService.page(new Page<>(pageNum,pageSize),wrapper);
        return new Result<>().success(new PageVO<>(page));
    }

    /**
     * 数据新增
     * @param notice
     * @return
     */
    @ApiOperation(value = "数据新增", notes = "数据新增")
    @PostMapping("/add")
    public Result add(@Validated @RequestBody SysRole notice) {
        sysRoleService.save(notice);
        return new Result<>().success();
    }

    /**
     * 数据更新
     * @param notice
     * @return
     */
    @ApiOperation(value = "数据更新", notes = "数据更新")
    @PutMapping("/update")
    public Result updateById(@Validated @RequestBody SysRole notice) {
        sysRoleService.updateById(notice);
        return new Result<>().success();
    }

    /**
     * 根据id删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @DeleteMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {
        sysRoleService.removeByIds(ids);
        return new Result<>().success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result<SysRole> getById(@RequestParam("id") Integer id) {
        SysRole notice = sysRoleService.getById(id);
        return new Result<>().success(notice);
    }

}
