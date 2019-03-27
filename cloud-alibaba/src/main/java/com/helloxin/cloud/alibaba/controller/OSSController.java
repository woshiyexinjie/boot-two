package com.helloxin.cloud.alibaba.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alicloud.sms.ISmsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OSSController {
	
	

	@GetMapping("/ossdown")
	public void ossdown() {
		
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = "";
		String accessKeySecret = "";
		String bucketName = "";
		String objectName = "work-stealing算法.pdf";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
		InputStream content = ossObject.getObjectContent();
		if (content != null) {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		    while (true) {
		        String line = null;
				try {
					line = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if (line == null) break;
		        System.out.println("\n" + line);
		    }
		    // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
		    try {
				content.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 关闭OSSClient。
		ossClient.shutdown();
		
	}

}
