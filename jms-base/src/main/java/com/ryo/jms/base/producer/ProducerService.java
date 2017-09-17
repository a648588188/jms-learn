package com.ryo.jms.base.producer;


import javax.jms.Destination;

/**
 * 消息生产者接口
 */
public interface ProducerService {

	/**
	 * 发送普通的纯文本消息
	 * @param destination
	 * @param message
	 */
	void sendMessage(Destination destination, String message);

}
