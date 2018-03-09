package com.mo1451.boot.webservice.services;



import com.mo1451.boot.webservice.dto.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IUserService {
    @WebMethod
    String getName(@WebParam(name = "userId") Long userId);
    @WebMethod
    User getUser(@WebParam(name = "userId") Long userId);
}
