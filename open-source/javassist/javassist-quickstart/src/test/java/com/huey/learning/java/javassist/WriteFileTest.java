package com.huey.learning.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import org.junit.Test;

/**
 * @author huey
 */
public class WriteFileTest {

    @Test
    public void testWriteFile() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.huey.learning.java.javassist.Rectangle");
        ctClass.setSuperclass(classPool.get("com.huey.learning.java.javassist.Point"));
        ctClass.writeFile();
    }

}
