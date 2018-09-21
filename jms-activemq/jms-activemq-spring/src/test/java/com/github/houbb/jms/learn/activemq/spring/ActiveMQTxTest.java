/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring;

import com.github.houbb.jms.learn.activemq.spring.service.ProducerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/20 上午9:11  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-mq-tx.xml"})
public class ActiveMQTxTest {

    @Autowired
    private ProducerService producerService;

    @Test
    public void sendTest() {
        producerService.sendMsg("hello spring jms local tx!");
    }

}
