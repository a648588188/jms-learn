/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/21 上午10:28  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class ConsumerSessionAwareMessageListener implements
        SessionAwareMessageListener<TextMessage> {

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("收到一条消息消息内容是：" + textMessage.getText());
        MessageProducer producer = session.createProducer(destination);
        Message newMessage = session.createTextMessage("ConsumerSessionAwareMessageListener send msg...");
        producer.send(newMessage);
    }

}
