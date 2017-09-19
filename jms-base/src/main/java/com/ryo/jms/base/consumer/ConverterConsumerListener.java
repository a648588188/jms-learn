package com.ryo.jms.base.consumer;

import com.ryo.jms.base.bean.Email;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class ConverterConsumerListener implements MessageListener {

	private MessageConverter messageConverter;

	public MessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
//				Object obj = objMessage.getObject();
//				Email email = (Email) obj;
				Email email = (Email) messageConverter.fromMessage(objMessage);
				System.out.println("接收到一个ObjectMessage，包含Email对象。"+email);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

	public void receiveMessage(String message) {
		System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
	}

	public void receiveMessage(Email email) {
		System.out.println("接收到一个包含Email的ObjectMessage。");
		System.out.println(email);
	}

}
