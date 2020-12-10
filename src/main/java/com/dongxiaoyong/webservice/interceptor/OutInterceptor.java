package com.dongxiaoyong.webservice.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Create By dongxiaoyong on /2020/10/18
 * description: WebService出拦截器（在发送消息给客户端时，修改命名空间或者XML消息内容）
 *
 * @author dongxiaoyong
 */
@Component
public class OutInterceptor extends AbstractSoapInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(OutInterceptor.class);


    public OutInterceptor() {
        //对应生命周期流关闭之前
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        OutputStream os = null;
        CachedOutputStream cs = null;
        try {
            //soapMessage转化输出流
            os = soapMessage.getContent(OutputStream.class);
            cs = new CachedOutputStream();
            //写入缓存流
            soapMessage.setContent(OutputStream.class,cs);
            //过滤链
            soapMessage.getInterceptorChain().doIntercept(soapMessage);
            CachedOutputStream csNew = (CachedOutputStream)soapMessage.getContent(OutputStream.class);
            InputStream in = csNew.getInputStream();
            String xml = IOUtils.toString(in);
            String xmlHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            // 这里对xml做处理，处理完后，写回流中
            xml = xmlHead + xml;
            IOUtils.copy(new ByteArrayInputStream(xml.getBytes("UTF-8")),os);
            soapMessage.setContent(OutputStream.class,os);

        } catch (Exception e) {
            logger.error("WebService出拦截器处理异常！", e);
        }
    }
}

