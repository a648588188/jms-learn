package com.ryo.jms.base.producer;


import javax.jms.Destination;
import java.io.Serializable;

/**
 * 消息生产者接口
 */
public interface ConverterProducerService {

	/**
	 * 发送普通的纯文本消息
	 * @param destination
	 * @param object
	 */
	void sendMessage(Destination destination, final Serializable object);

}
