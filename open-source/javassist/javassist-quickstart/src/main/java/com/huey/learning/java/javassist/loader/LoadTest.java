package com.huey.learning.java.javassist.loader;

import com.huey.learning.java.javassist.Hello;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @author huey
 */
public class LoadTest {

    public static void main(String[] args) throws Exception {
        Hello origHello = new Hello();
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.huey.learning.java.javassist.Hello");
        CtMethod method = ctClass.getDeclaredMethod("say");
        method.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        Class<?> clazz = ctClass.toClass();
        Hello hello = (Hello) clazz.newInstance();
        hello.say();
    }

}
