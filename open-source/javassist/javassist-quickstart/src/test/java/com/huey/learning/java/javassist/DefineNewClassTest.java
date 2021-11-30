package com.huey.learning.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import org.junit.Test;

/**
 * @author huey
 */
public class DefineNewClassTest {

    @Test
    public void testDefineNewClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("com.huey.learning.java.javassist.HelloWorld");
        CtField ctField = new CtField(CtClass.intType, "foo", ctClass);
        ctClass.addField(ctField);
        ctClass.writeFile();
    }

}
