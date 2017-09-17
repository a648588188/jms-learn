package com.ryo.jms.base.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/9/17
 * @since 1.7
 */
public class ConsumerSessionAwareMessageListener implements
        SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    /**
     *
     * @param message   当前接收到的消息Message
     * @param session   用来发送消息的Session对象
     * @throws JMSException
     */
    public void onMessage(TextMessage message, Session session) throws JMSException {
        System.out.println("收到一条消息消息内容是：" + message.getText());
        MessageProducer producer = session.createProducer(destination);
        Message textMessage = session.createTextMessage("ConsumerSessionAwareMessageListener send msg。。。");
        producer.send(textMessage);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
