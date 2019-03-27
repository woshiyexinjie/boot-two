package com.helloxin.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alicloud.sms.ISmsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SMSController {
	
	@Autowired
	private ISmsService smsService;

	@GetMapping("/sms")
	public SendSmsResponse sms() {
		log.info(" sms ");
		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号
		request.setPhoneNumbers("");
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName("");
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode("");
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//		request.setTemplateParam("");
	

		// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");

		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//		request.setOutId("****TraceId");
		request.setMethod(MethodType.POST);
		try {
			SendSmsResponse sendSmsResponse = smsService.sendSmsRequest(request);
			return sendSmsResponse;
		}  catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SendSmsResponse();
	}

}
