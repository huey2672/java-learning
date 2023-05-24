package com.huey.learning.java.feature.java14;

public class SwitchSample {

    public void sampleBeforeJava14(String season) {
        switch (season) {
            case "SPRING":
                System.out.println("春天");
                break;
            case "SUMMER":
                System.out.println("夏天");
                break;
            case "AUTUMN":
            case "FALL":
                System.out.println("秋天");
                break;
            case "WINTER":
                System.out.println("冬天");
            default:
                break;
        }
    }

    public void sampleInJava14(String season) {
        switch (season) {
            case "SPRING" -> System.out.println("春天");
            case "SUMMER" -> System.out.println("夏天");
            case "AUTUMN", "FALL" -> System.out.println("秋天");
            case "WINTER" -> System.out.println("冬天");
            default -> throw new IllegalArgumentException();
        }
    }

    public void switchSample2(String season) {
        String seasonText = switch (season) {
            case "SPRING" -> "春天";
            case "SUMMER" -> "夏天";
            case "AUTUMN", "FALL" -> "秋天";
            case "WINTER" -> "冬天";
            default -> {
                System.err.println("未知的季节");
                yield "";
            }
        };

    }

}
