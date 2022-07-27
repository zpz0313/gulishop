package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zpz
 * @email zpz0313@163.com
 * @date 2022-04-06 02:08:56
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
