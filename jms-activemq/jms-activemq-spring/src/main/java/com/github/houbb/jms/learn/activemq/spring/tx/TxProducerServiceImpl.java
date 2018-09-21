/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.tx;

import com.github.houbb.jms.learn.activemq.spring.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/20 上午9:04  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
@Service
public class TxProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Override
    public void sendMsg(String msg) {
        System.out.println("生产者发了一个消息：" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

}
