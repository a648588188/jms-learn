package com.ryo.jms.base.service;


import javax.jms.Destination;

public interface ProducerService {

	/**
	 * 发送普通的纯文本消息
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, String message);

}
