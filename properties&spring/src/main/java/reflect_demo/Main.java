package reflect_demo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("reflect_demo.Demo");//同包下直接写类名
        Demo demo = (Demo) clazz.newInstance();//新的实例
        //int result=demo.add(1,5);

       /* Field field = clazz.getDeclaredField("name");//获得成员变量
        field.setAccessible(true);//能不能访问，暴力访问
        field.set(demo,"wang");//修改*/


       /* Constructor con =  clazz.getConstructor(String.class);//获得构造函数，只能访问公有的
        //Constructor con1 = clazz.getDeclaredConstructor();//获取所有构造函数，不管公私
        con.newInstance("laowang");*/


        Method method =  clazz.getDeclaredMethod("add", int.class, int.class);//方法,不管公私
        AnnoTest test = method.getAnnotation(AnnoTest.class);//返回一个Anno类型
        System.out.println(test.desc());
        System.out.println(test.value());



       /* Class clax = method.getReturnType();
        int i = (int) method.invoke(demo,2,3);//反射调用
        System.out.println(i);*/
        //clazz.getMethod(),;//只能获取Public方法
    }
}
