package com.huey.learning.java.common.mathexpr;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

public class AviatorCase {

    public static void main(String[] args) {

        Expression expression = AviatorEvaluator.compile("2 * math.sin(x) + (y - 1) / 2");

        Map<String, Object> variables = new HashMap<>();
        variables.put("x", Math.PI);
        variables.put("y", 5);

        Double result = (Double) expression.execute(variables);
        System.out.println("result = " + result);

    }

}
