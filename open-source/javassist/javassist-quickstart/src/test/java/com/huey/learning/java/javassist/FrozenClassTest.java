package com.huey.learning.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import org.junit.Test;

/**
 * @author huey
 */
public class FrozenClassTest {

    @Test
    public void testFrozenClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.huey.learning.java.javassist.Rectangle");
        ctClass.setSuperclass(classPool.get("com.huey.learning.java.javassist.Point"));
        ctClass.writeFile();
        ctClass.addField(new CtField(CtClass.intType, "foo", ctClass));
    }

}
