package com.huey.learning.groovy.quickstart

class DefineVariableExample {

    static void main(String[] args) {

        // 像 Java 那样定义变量
        Date now = new Date();
        println(now);

        // 使用 def 定义变量
        def foo = 100;
        println(foo);

        // 动态类型
        foo = "Hello, World!";
        println(foo);

        foo = new Date();
        println(foo);

    }

}
