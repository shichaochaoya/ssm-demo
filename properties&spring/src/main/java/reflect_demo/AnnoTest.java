package reflect_demo;

import java.lang.annotation.*;

//自定义注解原理是动态代理

//描述自定义注解 叫 元注解
@Target(ElementType.METHOD)//目标限定只能用在成员变量
//@Retention(RetentionPolicy.SOURCE)//在java文件注解生效，编译后失效
//@Retention(RetentionPolicy.CLASS)//在Class中生效，运行时不生效
@Retention(RetentionPolicy.RUNTIME)//在运行时生效
//@Documented//是否生成文档
//@Inherited//所使用类子类是否生效，继承不继承
public @interface AnnoTest

{
    public String value();
    public String desc() default"这是一个描述" ;//可以给注解添加值


}
