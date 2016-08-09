package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by JokAr on 16/8/6.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnClick {
    int[] value();
}
