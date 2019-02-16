package me.sweeat.dojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Throwable {
        Student student = initByDefaultConst();
        student.introduce();

    }

    public static Student initByDefaultConst() throws Throwable {
        //通过类装载器获取Student对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("me.sweeat.dojo.Student");

        //获取类的默认构造器对象并通过它实例化student
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Student student = (Student) cons.newInstance();

        //通过反射方法设置属性
        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(student, "tom");
        Method setSex = clazz.getMethod("setSex", String.class);
        setSex.invoke(student, "male");
        return student;

    }
}
