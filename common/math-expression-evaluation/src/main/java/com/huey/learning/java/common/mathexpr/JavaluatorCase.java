package com.huey.learning.java.common.mathexpr;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

public class JavaluatorCase {

    public static void main(String[] args) {

        DoubleEvaluator evaluator = new DoubleEvaluator();

        String expression = "2 * sin(x) + (y - 1) / 2";

        StaticVariableSet<Double> variables = new StaticVariableSet<>();
        variables.set("x", Math.PI);
        variables.set("y", 5.0);

        Double result = evaluator.evaluate(expression, variables);
        System.out.println("result = " + result);

    }

}
