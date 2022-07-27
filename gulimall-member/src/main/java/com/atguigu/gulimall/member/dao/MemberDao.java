package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zpz
 * @email zpz0313@163.com
 * @date 2022-04-06 02:20:04
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
