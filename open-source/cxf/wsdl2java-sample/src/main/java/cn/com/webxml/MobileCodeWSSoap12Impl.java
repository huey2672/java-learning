
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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.1
 * 2020-12-20T17:09:05.173+08:00
 * Generated source version: 3.4.1
 *
 */

@javax.jws.WebService(
                      serviceName = "MobileCodeWS",
                      portName = "MobileCodeWSSoap12",
                      targetNamespace = "http://WebXml.com.cn/",
                      wsdlLocation = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl",
                      endpointInterface = "cn.com.webxml.MobileCodeWSSoap")

public class MobileCodeWSSoap12Impl implements MobileCodeWSSoap {

    private static final Logger LOG = Logger.getLogger(MobileCodeWSSoap12Impl.class.getName());

    /* (non-Javadoc)
     * @see cn.com.webxml.MobileCodeWSSoap#getMobileCodeInfo(java.lang.String mobileCode, java.lang.String userID)*
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
     * @see cn.com.webxml.MobileCodeWSSoap#getDatabaseInfo()*
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
