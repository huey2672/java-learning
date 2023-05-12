package com.huey.learning.groovy.quickstart

class MethodExample {

    def sum(int a, int b) {
        return a + b;
    }

    /**
     * 静态方法
     * @param a
     * @param b
     * @return
     */
    static def sum2(int a, int b) {
        return a + b;
    }

    /**
     * 支持默认参数
     * @param a
     * @param b
     * @return
     */
    def sum3(a, b = 0) {
        return a + b;
    }

}
