package com.huey.learning.groovy.quickstart

class StringExample {

    static def literalString() {

        // 用单引号括起的字符串
        def str1 = 'Hello, World';
        println(str1);

        // 用双引号括起的字符串
        def str2 = "Hello, World";
        println(str2);

        // 用三重引号括起的字符串，可跨行
        def str3 = '''{
          "foo": "123",
          "bar": "abc"
        }''';
        println(str3);

    }

    static def templateExample() {
        def name = "Huey";
        def template = "Hello, ${name}!";
        println(template);
    }

    static def concatenateExample() {
        def str1 = "Java";
        def str2 = "Script";
        def str3 = str1 + str2;
        println(str3);
    }

    static def repetitionExample() {
        def str1 = "Groovy";
        def str2 = str1 * 3;
        println(str2);
    }

    static def indexExample() {

        def str = "Groovy";

        // 获取索引为 1 的字符
        println(str[1]);

        // 获取最后一个字符
        println(str[-1]);

        // 同时获取索引为 1、3、5 的字符
        println(str[1, 3, 5]);

        // 获取索引范围 2 ~ 4 的字符
        println(str[2..4]);

        // 获取索引范围 -1 到 0 的字符，即反转字符串
        println(str[-1..0]);

    }

    static void main(String[] args) {

    }

}
