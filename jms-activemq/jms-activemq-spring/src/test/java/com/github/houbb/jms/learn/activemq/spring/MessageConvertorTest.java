/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring;

import com.github.houbb.jms.learn.activemq.spring.convertor.ConvertorProducerImpl;
import com.github.houbb.jms.learn.activemq.spring.convertor.model.Email;

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
@ContextConfiguration("classpath:application-mq-convertor.xml")
public class MessageConvertorTest {

    @Autowired
    private ConvertorProducerImpl convertorProducer;

    @Test
    public void sendMsg() {
        Email email = new Email("Dear MQ", "MQ 转换测试", "一些内容");
        convertorProducer.send(email);
    }

}
