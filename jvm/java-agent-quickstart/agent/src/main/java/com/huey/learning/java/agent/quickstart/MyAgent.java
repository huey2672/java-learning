package com.huey.learning.java.agent.quickstart;

import java.lang.instrument.Instrumentation;

/**
 * @author huey
 */
public class MyAgent {

    private static final String TARGET_CLASS_NAME = "com.huey.learning.java.agent.quickstart.HelloService";

    public static void premain(String agentArgs, Instrumentation instrumentation) throws Exception {
        // 创建 Transformer 对象
        MyTransformer myTransformer = new MyTransformer(TARGET_CLASS_NAME);
        // 注册 Transformer
        instrumentation.addTransformer(myTransformer, true);
        // 对于已经加载的类重新进行转换处理
        instrumentation.retransformClasses(Class.forName(TARGET_CLASS_NAME));
    }

}
