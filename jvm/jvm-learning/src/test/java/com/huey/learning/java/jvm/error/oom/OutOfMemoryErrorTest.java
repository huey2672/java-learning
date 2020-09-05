package com.huey.learning.java.jvm.error.oom;

import com.huey.learning.java.jvm.reference.type.TenMbObject;
import javassist.CannotCompileException;
import javassist.ClassPool;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author huey
 */
public class OutOfMemoryErrorTest {

    /**
     * test "java.lang.OutOfMemoryError: Java heap space" <br/>
     * JDK version: 1.8 <br/>
     * VM: HotSpot <br/>
     * VM options: -Xms100M -Xmx100M
     */
    @Test
    public void testJavaHeapSpace() {

        List<TenMbObject> list = new LinkedList<>();
        while (true) {
            list.add(new TenMbObject());
        }

    }

    /**
     * test "java.lang.OutOfMemoryError: GC overhead limit exceeded" <br/>
     * JDK version: 1.8 <br/>
     * VM: HotSpot <br/>
     * VM options: -Xmx10M -XX:+UseParallelGC
     */
    @Test
    public void testGcOverheadLimitExceeded() {

        Map<Integer, String> dataMap = new HashMap<>();
        Random random = new Random();
        while (true) {
            dataMap.put(random.nextInt(), String.valueOf(random.nextInt()));
        }

    }

    /**
     * test "java.lang.OutOfMemoryError: Metaspace" <br/>
     * JDK version: 1.8 <br/>
     * VM: HotSpot <br/>
     * VM options: -XX:MaxMetaspaceSize=64M
     *
     * @throws CannotCompileException
     */
    @Test
    public void testMetaspace() throws CannotCompileException {

        ClassPool classPool = ClassPool.getDefault();
        for (int i = 0; ; i++) {
            Class clazz = classPool.makeClass("com.huey.learning.java.jvm.error.oom.Test" + i).toClass();
        }

    }

    /**
     * test "java.lang.OutOfMemoryError: Requested array size exceeds VM limit" <br/>
     * JDK version: 1.8 <br/>
     * VM: HotSpot
     */
    @Test
    public void testRequestedArraySizeExceedsVmLimit() {
        byte[] data = new byte[Integer.MAX_VALUE];
    }

    /**
     * test "java.lang.OutOfMemoryError: unable to create new native thread" <br/>
     * JDK version: 1.8 <br/>
     * VM: HotSpot
     */
    @Test
    public void testUnableToCreateNewNativeThread() {

        while (true) {
            new Thread(() -> {
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }


}
