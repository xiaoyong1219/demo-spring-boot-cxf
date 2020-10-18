package com.dongxiaoyong.server;

import com.dongxiaoyong.webservice.CommonService;
import com.dongxiaoyong.webservice.HelloService;
import com.dongxiaoyong.webservice.interceptor.OutInterceptor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
/**
 * Create By dongxiaoyong on /2020/10/17
 * description: CXF webservice服务配置发布类
 *
 * @author dongxiaoyong
 */
@Configuration
public class CxfServerConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private CommonService commonService;

    @Autowired
    private HelloService helloService;

    @Autowired
    private OutInterceptor outInterceptor;

    /**
     * 发布CommonServiceImpl服务
     * 访问地址 http://127.0.0.1:8080/sws/common?wsdl
     * @param
     * @Author :dongxiaoyong
     * @Date : 2020/10/17 13:31
     * @return: javax.xml.ws.Endpoint
     */

    @Bean
    public Endpoint endpointCommon() {
        //CXF默认的服务路径是"/services/**"。如果想改变它的url。在application.yml中修改cxf.path的值
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/common");
        endpoint.getOutInterceptors().add(outInterceptor);
        return endpoint;
    }

    /**
     * 发布HelloServiceImpl服务
     * 访问地址 http://127.0.0.1:8080/ws/hello?wsdl
     * @param
     * @Author :dongxiaoyong
     * @Date : 2020/10/17 13:29
     * @return: javax.xml.ws.Endpoint
     */

    @Bean
    public Endpoint endpointHello() {
        //CXF默认的服务路径是"/services/**"。如果想改变它的url。在application.yml中修改cxf.path的值
        EndpointImpl endpoint = new EndpointImpl(bus, helloService);
        endpoint.publish("/hello");    //发布地址
        endpoint.getOutInterceptors().add(outInterceptor);
        return endpoint;

    }


}
