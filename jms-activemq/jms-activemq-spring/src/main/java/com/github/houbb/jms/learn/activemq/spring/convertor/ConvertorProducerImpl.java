/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import javax.jms.Destination;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/21 下午12:09  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
@Service
public class ConvertorProducerImpl {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination destination;

    public void send(final Serializable object) {
        // convertAndSend() 会调用具体的 convertor 转换方法
        jmsTemplate.convertAndSend(destination, object);
    }

}
