package com.huey.learning.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileReader;

public class RuleDescriptorCase {

    public static void main(String[] args) throws Exception {

        // 定义事实
        Facts zhangsan = new Facts();
        zhangsan.put("name", "张三");
        zhangsan.put("sex", "male");
        zhangsan.put("age", 27);

        // 定义规则
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        String ruleFilePath = "src/main/resources/marriageable-age-rule.yml";
        Rule marriageableAgeRule = ruleFactory.createRule(new FileReader(ruleFilePath));
        Rules marriageRules = new Rules();
        marriageRules.register(marriageableAgeRule);

        // 触发规则
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(marriageRules, zhangsan);

    }

}
