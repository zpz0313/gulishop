package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("coupon/coupon/coupons")
    public R memberCoupons();
}
