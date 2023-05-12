package com.huey.learning.groovy.quickstart

class ListExample {

    static def defineList() {
        def list = ["a", "b", "c", "d", "e", "f", "g"];
        def emptyList = [];
    }

    static def indexExample() {

        def list = ["a", "b", "c", "d", "e", "f", "g"];

        // 获取索引为 1 的元素
        println(list[1]);

        // 获取最后一个元素
        println(list[-1]);

        // 同时获取索引为 1、3、5 的元素
        println(list[1, 3, 5]);

        // 获取索引范围 2 ~ 4 的元素
        println(list[2..4]);

        // 获取索引范围 -1 到 0 的元素，即反转列表
        println(list[-1..0]);

    }

    static def traversalExample() {

        def list = ["a", "b", "c"];

        // for 循环
        for (int i = 0; i < list.size(); i++) {
            // 使用 list[i] 或 list.get(i) 表示当前元素
        }

        // for-in 循环
        for (e in list) {
            //
        }

        // forEach 遍历（lambda 表达式）
        list.forEach(e -> {
            println(e);
        });

        // each 遍历（闭包）
        list.each {
            e -> println(e);
        };
    }

    static def plusExample() {
        def list1 = ["a", "b", "c"];
        def list2 = ["d", "e"];
        def list3 = list1 + list2;	// 相当于 list3 = list1.plus(list2);
        println(list3);
        println(list1);
    }

    static def minusExample() {
        def list1 = ["a", "b", "c"];
        def list2 = ["d", "e"];
        def list3 = list1 + list2;	// 相当于 list3 = list1.plus(list2);
        println(list3);
        println(list1);
    }

}
