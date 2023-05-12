package com.huey.learning.groovy.quickstart

class MapExample {

    static def defineMap() {
        def map = ["a": 1, "b": 2, "c": 3];
        def emptyMap = [:];
    }

    static def traversalExample() {

        def map = ["a": 1, "b": 2, "c": 3];

        // for-in 循环
        for(Map.Entry it in map) {
            println(it.key + ": " + it.value);
        }

        // forEach 遍历（lambda 表达式）
        map.forEach((key, value) -> {
            println(key + ": " + value);
        })

        // each 遍历（闭包）
        map.each {
            println(it.key + ": " + it.value);
        }

    }

}
