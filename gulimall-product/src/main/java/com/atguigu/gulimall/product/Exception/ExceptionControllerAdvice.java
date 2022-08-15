package com.atguigu.gulimall.product.Exception;


import com.atguigu.common.Exception.ExceptionStatusCode;
import com.atguigu.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R ValidException(MethodArgumentNotValidException m){
        Map<String,String> map = new HashMap<>();

        BindingResult bindingResult = m.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(ExceptionStatusCode.VALID_EXCEPTION.getCode(),ExceptionStatusCode.VALID_EXCEPTION.getMessage()).put("data",map);
    }

}
