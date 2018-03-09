package com.mo1451.boot.webservice.util;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class UserWebService {

    public static void main(String[] args) {
        try {
            new UserWebService().invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invoke() throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8081/soap/user?wsdl");
        Object[] objects = client.invoke("getUser", 10002L);
        //输出调用结果
        System.out.println(objects[0].getClass());
        System.out.println(objects[0].toString());
    }
}
