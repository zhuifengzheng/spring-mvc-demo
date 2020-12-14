package org.com.yp.annotation;

import java.lang.annotation.*;

/**
 * 自定义mapper注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mapper {
}
