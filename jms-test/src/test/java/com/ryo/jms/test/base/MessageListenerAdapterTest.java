package com.ryo.jms.test.base;

import com.ryo.jms.base.producer.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-beans.xml")
public class MessageListenerAdapterTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    @Qualifier("adapterQueue")
    private Destination destination;

    @Test
    public void sendTest() {
        producerService.sendMessage(destination, "Hello! message is: adapterQueue msg!");
    }

}
