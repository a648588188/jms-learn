package com.ryo.jms.base.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/7/5
 * @since 1.7
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage>  {


    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {

    }

}
