package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> list = baseMapper.selectList(null);

        List<CategoryEntity> entityList = list.stream().filter(CategoryEntity ->
                        CategoryEntity.getParentCid() == 0
                )
                .map(menu -> {
                    menu.setChildren(getChildren(menu, list));
                    return menu;
                }).sorted((menu1, menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }).collect(Collectors.toList());
        return entityList;
    }


    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(CategoryEntity -> {
                    return CategoryEntity.getParentCid() == root.getCatId();
                })
                .map(menu -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                }).sorted((menu1, menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }).collect(Collectors.toList());
        return children;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        // TODO 判断是否有其他业务引用该目录，优先处理

        // 逻辑删除菜单目录
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] getPathById(Long catelogid) {
        List<Long> list = new ArrayList<>();
        list.add(catelogid);
        getMenus(catelogid, list);
        Collections.reverse(list);
        return list.stream().toArray(Long[]::new);
    }

    public void getMenus(Long catelogid, List<Long> list) {
        CategoryEntity categoryEntity = baseMapper.selectById(catelogid);
        if (categoryEntity.getParentCid() != 0) {
            list.add(categoryEntity.getParentCid());
            getMenus(categoryEntity.getParentCid(), list);
        }
    }

}