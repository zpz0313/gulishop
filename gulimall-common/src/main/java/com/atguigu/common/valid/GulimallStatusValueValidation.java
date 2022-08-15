package com.atguigu.common.valid;

import com.atguigu.common.Exception.ExceptionStatusCode;
import com.atguigu.common.utils.R;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.HashSet;
import java.util.Set;

public class GulimallStatusValueValidation implements ConstraintValidator<GulimallStatusValue,Integer> {

    Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(GulimallStatusValue constraintAnnotation) {

        int[] value = constraintAnnotation.value();
//        if (set.size()!=0){
            for(int v: value ){
                set.add(v);
            }
//        }else{
//            System.out.println("@GulimallStatusValid-注解校验器失效，空值:gulimall-common下的valid包下的GulimallStatusValueValidation类出错");
//        }


    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean contains = set.contains(integer);
//        set.removeAll(set);
        return contains;
    }
}
