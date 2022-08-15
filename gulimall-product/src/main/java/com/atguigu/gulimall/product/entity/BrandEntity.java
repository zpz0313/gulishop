package com.atguigu.gulimall.product.entity;

import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.GulimallStatusValue;
import com.atguigu.common.valid.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author zpz
 * @email zpz0313@163.com
 * @date 2022-04-05 01:46:49
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名称不能为空(BrandEntity-name)",groups = {AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "logo不能为空(BrandEntity-logo)",groups = {AddGroup.class,UpdateGroup.class})
	@URL(message = "logo不符合URL定义(BrandEntity-logo)",groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@GulimallStatusValue(value = {0,1},groups = {AddGroup.class,UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(message = "检索首字母不能为空(BrandEntity-logo)",groups = {AddGroup.class,UpdateGroup.class})
	@Pattern(regexp = "^[A-Za-z]$", message = "检索首字母必须是单个字母(BrandEntity-logo)",groups = {AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序不能为空(BrandEntity-logo)",groups = {AddGroup.class, UpdateGroup.class})
	@Min(value = 0,message = "排序字段为正整数(BrandEntity-logo)",groups = {AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
