package com.helloxin.es;

import com.helloxin.es.document.GoodsInfo;
import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.document.ProductDocumentBuilder;
import com.helloxin.es.service.EsSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
    private EsSearchService esSearchService;
	
	@Test
	public void save() {
		
		ProductDocument productDocument = ProductDocumentBuilder.create().addId(System.currentTimeMillis() + "01")
				.addProductName("无印良品 MUJI 基础润肤化妆水").addProductDesc("无印良品 MUJI 基础润肤化妆水 高保湿型 200ml")
				.addCreateTime(new Date()).addUpdateTime(new Date()).builder();

		ProductDocument productDocument1 = ProductDocumentBuilder.create().addId(System.currentTimeMillis() + "02")
				.addProductName("荣耀 V10 尊享版").addProductDesc("荣耀 V10 尊享版 6GB+128GB 幻夜黑 移动联通电信4G全面屏游戏手机 双卡双待")
				.addCreateTime(new Date()).addUpdateTime(new Date()).builder();

		ProductDocument productDocument2 = ProductDocumentBuilder.create().addId(System.currentTimeMillis() + "03")
				.addProductName("资生堂(SHISEIDO) 尿素红罐护手霜")
				.addProductDesc("日本进口 资生堂(SHISEIDO) 尿素红罐护手霜 100g/罐 男女通用 深层滋养 改善粗糙").addCreateTime(new Date())
				.addUpdateTime(new Date()).builder();

		esSearchService.save(productDocument, productDocument1, productDocument2);

	}

	@Test
	public void saveSimple() {
		GoodsInfo goodsInfo = new GoodsInfo("羽绒服","保暖靠谱",new Date());
		ProductDocument productDocument = ProductDocument.builder().id(System.currentTimeMillis() + ((int)Math.random()*100+""))
				.productName("优衣库 无缝羽绒服").productDesc("优衣库 无缝羽绒服抵挡零下20度的寒冷稳稳的")
				.createTime(new Date()).updateTime(new Date()).goods(goodsInfo).build();
		esSearchService.save(productDocument);
	}

	@Test
	public void deleteDocument(){
		esSearchService.deleteById("158056306423452.72357104462638");
	}

	@Test
	public void deleteAllDocument(){
		esSearchService.deleteAll();
	}
}
