package com.huey.learning.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

public class FluentAPICase {

    public static void main(String[] args) {

        // 定义事实
        Facts zhangsan = new Facts();
        zhangsan.put("name", "张三");
        zhangsan.put("sex", "male");
        zhangsan.put("age", 27);

        // 定义规则
        Rule marriageableAgeRule = new RuleBuilder()
                .name("法定结婚年龄规则")
                .description("如果到法定结婚年龄，则可以办理结婚登记")
                .when(facts -> {
                    String sex = facts.get("sex");
                    Integer age = facts.get("age");
                    return ("male".equals(sex) && age >= 22) || ("female".equals(sex) && age >= 20);
                })
                .then(facts -> System.out.println(facts.get("name") + "已到法定结婚年龄，可以办理结婚登记"))
                .build();
        Rules marriageRules = new Rules();
        marriageRules.register(marriageableAgeRule);

        // 触发规则
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(marriageRules, zhangsan);

    }

}
