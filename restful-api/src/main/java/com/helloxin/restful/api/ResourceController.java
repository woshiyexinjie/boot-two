package com.helloxin.restful.api;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResourceController {

	@RequestMapping(value = "/produces",produces = "application/xml")
	@ResponseBody
	public String getResouces() {
		//这里标注返回的数据为xml格式
        Element root2 = DocumentHelper.createElement("student");
		return root2.asXML();
	}
}
