package com.dongxiaoyong.webservice.impl;

import com.dongxiaoyong.webservice.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Create By dongxiaoyong on /2020/10/17
 * description: CommonService实现
 *
 * @author dongxiaoyong
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.dongxiaoyong.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.dongxiaoyong.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHi(String name) {
        return "Hi ," + name;
    }

}
