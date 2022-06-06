package com.huey.learning.java.javassist.loader;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;

import java.lang.reflect.Method;

/**
 * @author huey
 */
public class MyTranslator implements Translator {

    @Override
    public void start(ClassPool pool) throws NotFoundException, CannotCompileException {

    }

    @Override
    public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
        CtClass ctClass = pool.getCtClass(classname);
        CtMethod ctMethod = CtNewMethod.make("public void hi() { System.out.println(\"Hi\"); }", ctClass);
        ctClass.addMethod(ctMethod);
    }

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        Translator translator = new MyTranslator();
        Loader loader = new Loader();
        loader.addTranslator(pool, translator);
        Class<?> helloClass = loader.loadClass("com.huey.learning.java.javassist.Hello");
        Method hi = helloClass.getDeclaredMethod("hi");
        hi.invoke(helloClass.newInstance());
    }

}
