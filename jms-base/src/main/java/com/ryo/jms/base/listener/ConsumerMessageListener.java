package com.ryo.jms.base.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		try {
			System.out.println("ConsumerMessageListener onMessage: "+textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
