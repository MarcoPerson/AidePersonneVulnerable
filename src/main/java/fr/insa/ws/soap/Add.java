package fr.insa.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "adder")
public class Add {
    @WebMethod(operationName = "addUserInNeed")
    public boolean addUserInNeed(@WebParam(name = "userName") String name){
        return true;
    }

    @WebMethod(operationName = "addUserInCharge")
    public boolean addUserInCharge(@WebParam(name = "userName") String name){
        return true;
    }
}
