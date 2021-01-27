package com.huey.learning.java.jdk.javac.sample;

import java.util.ArrayList;
import java.util.List;

public class Data {

    List<String> textList = new ArrayList<>();

    public void addText(String text) {
        textList.add(text);
    }

    public List<String> getTextList() {
        return this.textList;
    }

}