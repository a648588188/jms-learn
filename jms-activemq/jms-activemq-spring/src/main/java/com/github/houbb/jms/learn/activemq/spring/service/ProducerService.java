/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.service;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/20 上午9:02  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public interface ProducerService {

    /**
     * 发送消息
     * @param msg 消息
     */
    void sendMsg(final String msg);

}
