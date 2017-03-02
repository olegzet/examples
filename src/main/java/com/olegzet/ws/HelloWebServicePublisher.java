package com.olegzet.ws;

import javax.xml.ws.Endpoint;

/**
 * Created by oleg.zorin on 02.03.2017.
 */
public class HelloWebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());

    }
}
