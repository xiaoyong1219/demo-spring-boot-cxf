package com.dongxiaoyong.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Create By dongxiaoyong on /2020/10/17
 * description: CommonService接口
 *
 * @author dongxiaoyong
 */
@WebService(name = "CommonService", // 暴露服务名称
		targetNamespace = "http://webservice.dongxiaoyong.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
	@WebMethod
	@WebResult(name = "String", targetNamespace = "")
	String sayHi(@WebParam(name = "userName") String name);

}
