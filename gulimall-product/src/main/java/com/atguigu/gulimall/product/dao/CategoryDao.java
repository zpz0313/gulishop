package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zpz
 * @email zpz0313@163.com
 * @date 2022-04-05 01:46:49
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
