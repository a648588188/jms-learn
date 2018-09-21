/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.adaptor;

import java.io.Serializable;
import java.util.Map;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/21 上午11:16  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class DefaultMessageDelegate implements MessageDelegate {
    @Override
    public void handleMessage(String message) {
        System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    @Override
    public void handleMessage(Map message) {

    }

    @Override
    public void handleMessage(byte[] message) {

    }

    @Override
    public void handleMessage(Serializable message) {

    }
}
