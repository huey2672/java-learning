package com.huey.learning.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Loader;
import javassist.bytecode.ClassFile;
import javassist.bytecode.FieldInfo;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author huey
 */
public class AddFieldTest {

    @Test
    public void testAddField() throws Exception {

        // 获取 ClassPool
        ClassPool classPool = ClassPool.getDefault();
        // 获取 Point 类的 CtClass
        CtClass pointCtClass = classPool.get(Point.class.getName());
        // 获取 String 类的 CtClass
        CtClass typeClass = classPool.get(String.class.getName());
        // 创建一个 String 类型的、名为 color 的字段
        CtField colorCtField = new CtField(typeClass, "color", pointCtClass);
//        CtField colorCtField = CtField.make("private java.lang.String color = \"Red\";", pointCtClass);
        // 为 Point 类添加 color 字段
        pointCtClass.addField(colorCtField);
//        pointCtClass.addField(colorCtField, "Red");


        // 使用 javassist 的类加载器加载 Point 类
        Loader classLoader = new Loader(classPool);
        Class<?> newPointClass = classLoader.loadClass(pointCtClass.getName());

        // 验证新加载的 Point 类是否有 color 字段
        boolean hasColorField = Arrays.stream(newPointClass.getDeclaredFields())
                .map(Field::getName)
                .anyMatch("color"::equals);
        Assert.assertTrue(hasColorField);

        Object pointInst = newPointClass.newInstance();
        Field colorField = newPointClass.getDeclaredField("color");
        colorField.setAccessible(true);
        Object color = colorField.get(pointInst);
        Assert.assertEquals("Red", color);

    }

    @Test
    public void testAddField2() throws Exception {

        // 获取 ClassPool
        ClassPool classPool = ClassPool.getDefault();

        // 获取 Point 类的 CtClass
        CtClass ctClass = classPool.get(Point.class.getName());

        ClassFile classFile = ctClass.getClassFile();

        FieldInfo fieldInfo = new FieldInfo(classFile.getConstPool(), "color", "Ljava/lang/String;");

        classFile.addField(fieldInfo);

        Loader classLoader = new Loader(classPool);
        Field[] fields = classLoader.loadClass(Point.class.getName()).getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName());
        }

    }

}
