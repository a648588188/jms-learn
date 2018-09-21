/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/21 上午10:32  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mq-listener-adapter.xml")
public class ConsumerListenerAdapterTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("adapterQueue")
    private Destination destination;

    @Test
    public void sendMsg() {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("adapterQueue 发送测试");
            }
        });
    }

}
