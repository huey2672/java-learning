package com.huey.learning.java.agent.quickstart;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author huey
 */
public class MyTransformer implements ClassFileTransformer {

    private final String targetClassName;

    public MyTransformer(String targetClassName) {
        this.targetClassName = targetClassName;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        byte[] byteCode = classfileBuffer;

        // 如果类不能转换，则直接返回 classfileBuffer
        if (!canTransform(className)) {
            return byteCode;
        }

        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(this.targetClassName);
            CtMethod[] declaredMethods = ctClass.getDeclaredMethods();
            for (CtMethod ctMethod : declaredMethods) {
                ctMethod.addLocalVariable("startTime", CtClass.longType);
                ctMethod.insertBefore("startTime = System.currentTimeMillis();");
                ctMethod.addLocalVariable("endTime", CtClass.longType);
                ctMethod.addLocalVariable("opTime", CtClass.longType);
                String endBlock = "endTime = System.currentTimeMillis();" +
                        "opTime = endTime - startTime;" +
                        "System.out.println(\"Method [" + this.targetClassName + "] completed in: \" + opTime + \" ms!\");";
                ctMethod.insertAfter(endBlock);
            }
            byteCode = ctClass.toBytecode();
            ctClass.detach();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }

        return byteCode;

    }

    /**
     * 判断类是否能转换
     *
     * @param className
     * @return
     */
    private boolean canTransform(String className) {
        String finalTargetClassName = this.targetClassName.replaceAll("\\.", "/");
        return className.equals(finalTargetClassName);
    }

}
