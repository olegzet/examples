package com.olegzet.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by oleg.zorin on 02.03.2017.
 */
public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:1986/wss/hello?wsdl");
        QName qname = new QName("http://ws.olegzet.com/", "HelloWebServiceImplService");
        Service service = Service.create(url, qname);
        HelloWebService hello = service.getPort(HelloWebService.class);
        System.out.println(hello.getHelloString("Oleg"));
    }
}
