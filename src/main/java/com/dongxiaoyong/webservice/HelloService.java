package com.dongxiaoyong.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Create By dongxiaoyong on /2020/10/17
 * description: HelloService接口
 *
 * @author dongxiaoyong
 */
@WebService(name = "HelloService", // 暴露服务名称
        targetNamespace = "http://webservice.dongxiaoyong.com/"// 命名空间,一般是接口的包名倒序
)
public interface HelloService {
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String sayHello(@WebParam(name = "userName") String name);

}