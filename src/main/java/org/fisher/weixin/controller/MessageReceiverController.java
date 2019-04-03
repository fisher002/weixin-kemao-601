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
	public String echo(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
		return echostr;
	}

	@PostMapping
	public String onMessage(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestBody String xml)
			throws JsonParseException, JsonMappingException, IOException {
                System.out.println(xml);
		// 收到消息并打印
		LOG.trace("收到的消息原文：\n{}\n------------------------------", xml);
		// 转换消息1.获取消息的类型
		InMessage inMessage = MessageConvertHelper.convert(xml);

		LOG.debug("转换后的消息\n{}\n", inMessage);

		return "success";
	}

}
