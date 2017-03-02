package com.olegzet.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by oleg.zorin on 02.03.2017.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {
    @WebMethod
    public String getHelloString(String name);
}
