package com.ryo.jms.base.consumer;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/9/17
 * @since 1.7
 */
public class ConsumerMessageListenerAdapterListener {

    public void handleMessage(String message) {
        System.out.println("ConsumerMessageListenerAdapterListener handleMessage get msg：" + message);
    }

    public void receiveMessage(String message) {
        System.out.println("ConsumerMessageListenerAdapterListener receiveMessage get msg：" + message);
    }

}
