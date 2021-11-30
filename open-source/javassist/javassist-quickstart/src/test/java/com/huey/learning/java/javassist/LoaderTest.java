package com.huey.learning.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.Loader;

/**
 * @author huey
 */
public class LoaderTest {

    public static void main(String[] args) throws Exception {

        ClassPool classPool = ClassPool.getDefault();
        Loader loader = new Loader(classPool);

        CtClass ctClass = classPool.get("com.huey.learning.java.javassist.Rectangle");
        ctClass.setSuperclass(classPool.get("com.huey.learning.java.javassist.Point"));

        Class<?> clazz = loader.loadClass("com.huey.learning.java.javassist.Rectangle");
        Object rectangle = clazz.newInstance();

    }

}
