
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package cn.com.webxml;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.4.1
 * 2020-12-20T17:09:05.235+08:00
 * Generated source version: 3.4.1
 *
 */

@javax.jws.WebService(
                      serviceName = "MobileCodeWS",
                      portName = "MobileCodeWSHttpGet",
                      targetNamespace = "http://WebXml.com.cn/",
                      wsdlLocation = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl",
                      endpointInterface = "cn.com.webxml.MobileCodeWSHttpGet")

public class MobileCodeWSHttpGetImpl implements MobileCodeWSHttpGet {

    private static final Logger LOG = Logger.getLogger(MobileCodeWSHttpGetImpl.class.getName());

    /* (non-Javadoc)
     * @see cn.com.webxml.MobileCodeWSHttpGet#getMobileCodeInfo(java.lang.String mobileCode, java.lang.String userID)*
     */
    public java.lang.String getMobileCodeInfo(java.lang.String mobileCode, java.lang.String userID) {
        LOG.info("Executing operation getMobileCodeInfo");
        System.out.println(mobileCode);
        System.out.println(userID);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see cn.com.webxml.MobileCodeWSHttpGet#getDatabaseInfo()*
     */
    public cn.com.webxml.ArrayOfString getDatabaseInfo() {
        LOG.info("Executing operation getDatabaseInfo");
        try {
            cn.com.webxml.ArrayOfString _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
