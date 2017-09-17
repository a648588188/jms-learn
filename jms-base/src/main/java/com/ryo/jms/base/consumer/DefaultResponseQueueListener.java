package com.ryo.jms.base.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/9/17
 * @since 1.7
 */
public class DefaultResponseQueueListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("DefaultResponseQueueListener get msg: "+message);
//        if (message instanceof TextMessage) {
//            TextMessage textMessage = (TextMessage) message;
//            try {
//                System.out.println("DefaultResponseQueueListener接收到发送到defaultResponseQueue的一个文本消息，内容是：" + textMessage.getText());
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
