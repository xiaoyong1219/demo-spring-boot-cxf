package com.dongxiaoyong.client;

import com.dongxiaoyong.webservice.CommonService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
/**
 * Create By dongxiaoyong on /2020/10/17
 * description: CXF webservice调用客户端
 *
 * @author dongxiaoyong
 */
public class CxfClient {
	public static void main(String[] args) {
		cl1();
	}

	/**
	 * 方式1.代理类工厂的方式,需要拿到对方的接口
	 */
	public static void cl1() {
		try {
			// 接口地址
			String address = "http://localhost:8080/ws/common?wsdl";
			// 代理工厂
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
			// 设置代理地址
			jaxWsProxyFactoryBean.setAddress(address);
			// 设置接口类型
			jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
			// 创建一个代理接口实现
			CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
			// 数据准备
			String userName = "dongxiaoyong";
			// 调用代理接口的方法调用并返回结果
			String result = cs.sayHi(userName);
			System.out.println("返回结果:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
