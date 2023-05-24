package com.huey.learning.java.feature.java12;

public class StringIndentSample {

    public static void main(String[] args) {

        String text = "窗前明月光，\n疑似地上霜。\n" +
                "举头望明月，\n低头思故乡。";
        text = text.indent(2);
        System.out.println(text);

    }

}
