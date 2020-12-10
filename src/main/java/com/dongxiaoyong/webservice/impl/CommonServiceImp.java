package com.dongxiaoyong.webservice.impl;

import com.alibaba.fastjson.JSON;
import com.dongxiaoyong.webservice.CommonService;
import com.dongxiaoyong.webservice.enetity.UserBean;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
public class CommonServiceImp implements CommonService {

    @Override
    public String sayHi(String name) {
        return "Hi ," + name;
    }

    @Override
    public String sayHiTwo(String json) {
        UserBean userBean = new UserBean();
        if (StringUtils.isEmpty(json)) {
            return "参数不能为空！";
        } else {
            userBean = JSON.parseObject(json, UserBean.class);
            if(StringUtils.isEmpty(userBean.getName())){
                return "姓名不能为空！";
            }
        }
        return "Hi ," + userBean.getName() + "年龄：" + userBean.getAge() + "，手机号：" + userBean.getPhone() + "，出生日期：" + userBean.getBirthdate();
    }


}
