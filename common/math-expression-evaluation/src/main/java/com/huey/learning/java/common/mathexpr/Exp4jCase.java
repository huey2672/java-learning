package com.huey.learning.java.common.mathexpr;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Exp4jCase {

    public static void main(String[] args) {

        Expression expression = new ExpressionBuilder("2 * sin(x) + (y - 1) / 2")
                .variables("x", "y")
                .build()
                .setVariable("x", Math.PI)
                .setVariable("y", 5);
        double result = expression.evaluate();

        System.out.println("result = " + result);
    }

}
