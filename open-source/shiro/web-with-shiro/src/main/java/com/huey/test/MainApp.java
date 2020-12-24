package com.huey.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huey
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println(test());

    }

    public static boolean test() {

        // A 端省份
        String aProvinceCode = "36";
        // Z 端省份
        String zProvinceCode = "36";
        // 受理省份
        String acceptProvinceCode = "51";

        // A 端与 Z 端的省份不同
        if (!StringUtils.equals(aProvinceCode, zProvinceCode)) {
            return true;
        }

        // 与受理省份不同
        return !StringUtils.equals(aProvinceCode, acceptProvinceCode);

    }


}
