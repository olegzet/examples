package com.olegzet.ws;

import javax.jws.WebService;

/**
 * Created by oleg.zorin on 02.03.2017.
 */

@WebService(endpointInterface = "com.olegzet.ws.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {
    @Override
    public String getHelloString(String name) {
        return "Hello, " + name + "!";
    }

}
