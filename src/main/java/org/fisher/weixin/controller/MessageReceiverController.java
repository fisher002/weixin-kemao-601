package org.fisher.weixin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

import org.fisher.weixin.controller.inmessage.InMessage;
import org.fisher.weixin.service.MessageConvertHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@RestController是满足RESTful风格的一种控制器实现，实际上它还是@Controller。
//但是@RestController只是返回内容，不返回视图（JSP、HTML）。
@RestController
@RequestMapping("/zjy/message/receiver")
public class MessageReceiverController {
	
	// 日志记录器
	private static final Logger LOG = LoggerFactory.getLogger(MessageReceiverController.class);
	
	@GetMapping
	public String echo(
			@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,
			@RequestParam("echostr") String echostr
			) {
		return echostr;
	}
	
	@PostMapping
	// @RequestBody注解表示把请求内容获取出来，并且转换为String传入给xml参数。
	public String onMessage(//
			@RequestParam("signature")
			String signature, //
			@RequestParam("timestamp") 
			String timestamp, //
			@RequestParam("nonce") 
			String nonce, //
			@RequestBody 
			String xml) throws JsonParseException, JsonMappingException, IOException {
		// 收到消息
		// {}是占位符，第一个{}会把第二个参数的值自动填入
		// LOG.trace必须要求日志记录器的配置为trace级别才能输出
		LOG.trace("收到的消息原文：\n{}\n------------------------------", xml);
		// 转换消息
		// 转换消息1.获取消息的类型
		InMessage inMessage=MessageConvertHelper.convert(xml);
		
		LOG.debug("转换后的消息\n{}\n",inMessage);
		
		
		return "获取成功";
	}

}
