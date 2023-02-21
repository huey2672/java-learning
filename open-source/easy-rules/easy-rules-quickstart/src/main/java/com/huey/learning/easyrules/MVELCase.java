package com.huey.learning.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;

public class MVELCase {

    public static void main(String[] args) {

        // 定义事实
        Facts zhangsan = new Facts();
        zhangsan.put("name", "张三");
        zhangsan.put("sex", "male");
        zhangsan.put("age", 27);

        // 定义规则
        Rule marriageableAgeRule = new MVELRule()
                .name("法定结婚年龄规则")
                .description("如果到法定结婚年龄，则可以办理结婚登记")
                .when("(sex == 'male' && age >= 22) || (sex == 'female' && age >= 20)")
                .then("System.out.println(name + \"已到法定结婚年龄，可以办理结婚登记\");");
        Rules marriageRules = new Rules();
        marriageRules.register(marriageableAgeRule);

        // 触发规则
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(marriageRules, zhangsan);

    }

}
