package com.ryo.jms.base.producer.impl;

import com.ryo.jms.base.producer.ConverterProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/9/19
 * @since 1.7
 */
@Service
public class ConverterProducerServiceImpl implements ConverterProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Override
    public void sendMessage(Destination destination, Serializable object) {
        jmsTemplate.send(destination, session -> session.createObjectMessage(object));
    }

}
