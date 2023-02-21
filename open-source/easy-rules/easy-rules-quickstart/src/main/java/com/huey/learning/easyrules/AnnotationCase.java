package com.huey.learning.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

public class AnnotationCase {

    public static void main(String[] args) {

        // 定义事实
        Facts zhangsan = new Facts();
        zhangsan.put("name", "张三");
        zhangsan.put("sex", "male");
        zhangsan.put("age", 27);

        // 定义规则
        MarriageableAgeRule marriageableAgeRule = new MarriageableAgeRule();
        Rules marriageRules = new Rules();
        marriageRules.register(marriageableAgeRule);

        // 触发规则
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(marriageRules, zhangsan);

    }

}
