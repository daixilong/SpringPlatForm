package com.urp.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created by a on 2018/5/22.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dict {
    /**
     * 类型
     *
     * @return
     */
    public String type() default "";

    /**
     * 默认值
     *
     * @return
     */
    public String defaultDisplay() default "";

    /**
     * 字典文本的后缀
     *
     * @return
     */
    public String suffix() default "Text";
}
