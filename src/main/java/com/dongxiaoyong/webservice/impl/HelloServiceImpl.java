package com.dongxiaoyong.webservice.impl;

import com.dongxiaoyong.webservice.HelloService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Create By dongxiaoyong on /2020/10/17
 * description: HelloService实现
 *
 * @author dongxiaoyong
 */
@WebService(serviceName = "HelloService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.dongxiaoyong.com/", // 与接口中的命名空间一致,一般是接口的包名倒序
        endpointInterface = "com.dongxiaoyong.webservice.HelloService"// 接口地址
)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }
}
