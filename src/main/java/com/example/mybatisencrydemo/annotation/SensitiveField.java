package com.example.mybatisencrydemo.annotation;

import java.lang.annotation.*;

/**
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/9 14:06
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SensitiveField {
}
