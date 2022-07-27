package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zpz
 * @email zpz0313@163.com
 * @date 2022-04-06 02:30:27
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
