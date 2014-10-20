package com.annotation;

import java.lang.reflect.Method;

public class Test_1
{
    /*
     * 被注解的三个方法
     */
    @Test(id = 1, description = "hello method_1")
    public void method_1()
    {
    }

    @Test(id = 2)
    public void method_2()
    {
    }

    @Test(id = 3, description = "last method")
    public void method_3()
    {
    }

    /*
     * 解析注解，将Test_1类 所有被注解方法 的信息打印出来
     */
    public static void main(String[] args)
    {
        Method[] methods = Test_1.class.getDeclaredMethods();
        for (Method method : methods)
        {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(Test.class);
            if (hasAnnotation)
            {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                Test annotation = method.getAnnotation(Test.class);
                System.out.println("Test( method = " + method.getName() + " , id = " + annotation.id()
                        + " , description = " + annotation.description() + " )");
            }
        }
    }

}