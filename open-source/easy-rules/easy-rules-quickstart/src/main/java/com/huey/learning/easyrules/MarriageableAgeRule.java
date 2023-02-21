package com.huey.learning.easyrules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "法定结婚年龄规则", description = "如果到法定结婚年龄，则可以办理结婚登记")
public class MarriageableAgeRule {

    @Condition
    public boolean condition(@Fact("sex") String sex, @Fact("age") Integer age) {
        return ("male".equals(sex) && age >= 22) || ("female".equals(sex) && age >= 20);
    }

    @Action
    public void action(@Fact("name") String name) {
        System.out.println(name + "已到法定结婚年龄，可以办理结婚登记");
    }

}
