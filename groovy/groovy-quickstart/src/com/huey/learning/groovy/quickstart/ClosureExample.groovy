package com.huey.learning.groovy.quickstart

class ClosureExample {

    def simpleExample() {
        def closure = { println "Hello World" };
        closure.call();
    }

    def parameterExample() {
        def closure = { name -> println "Hello " + name };
        closure.call("World");
    }

    def implicitParameterExample() {
        def closure = { println "Hello " + it };
        closure.call("World");
    }

    def referenceVariableExample() {
        def greet = "Hello"
        def closure = { println greet + " " + it };
        closure.call("World");
    }

    

}
