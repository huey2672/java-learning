package com.huey.learning.java.jdk.wsimport;

import cn.com.webxml.ws.mobilecodews.MobileCodeWS;
import cn.com.webxml.ws.mobilecodews.MobileCodeWSSoap;

/**
 * @author huey
 */
public class WsimportSample {

    public static void main(String[] args) {

        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();

        String result = mobileCodeWSSoap.getMobileCodeInfo("1892672", null);
        System.out.println(result);

    }

}
