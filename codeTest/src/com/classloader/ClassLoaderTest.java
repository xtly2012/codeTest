package com.classloader;


public class ClassLoaderTest
{
    @SuppressWarnings("static-access")
    public static void main(String[] argus) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        TempClassLoader loader = new TempClassLoader(null, "tempClassLoader");
        TempClassLoader loader1 = new TempClassLoader(loader, "tempClassLoader");
        loader1.setPath("D:/workspace");
        Thread.currentThread().setContextClassLoader(loader1);
        
        System.out.println("tempClassLoader classLoader is " +loader1.getParent().toString());
        System.out.println("tempClassLoader systemClassLoader is " +loader1.getParent().getSystemClassLoader().toString());
        
        @SuppressWarnings("unchecked")
        Class<TestBean> cls = (Class<TestBean>) loader1.loadClass("com.classloader.TestBean");
        TestBean bean = cls.newInstance();
        ClassLoader loader2 = bean.getClass().getClassLoader();
        System.out.println("TestBean classloader is " +loader2.toString());
        System.out.println("TestBean parent classloader is " +loader2.getParent().toString());
        System.out.println("TestBean systemclassloader is " +loader2.getSystemClassLoader().toString());
        System.out.println("TestBean classloader url is " +loader2.getResource("com").toString());
        
        
        loader2 = ClassLoaderTest.class.getClassLoader();
        System.out.println("ClassLoaderTest classloader is " +loader2.toString());
        System.out.println("ClassLoaderTest parent classloader is " +loader2.getParent().toString());
        System.out.println("ClassLoaderTest systemclassloader is " +loader2.getSystemClassLoader().toString());
        System.out.println("ClassLoaderTest classloader url is " +loader2.getResource("com").toString());
        
        loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println("thread contextClassLoader is " +loader2.toString());
        System.out.println("ClassLoaderTest parent classloader is " +loader2.getParent().toString());
        System.out.println("ClassLoaderTest systemclassloader is " +loader2.getSystemClassLoader().toString());
    }
}
