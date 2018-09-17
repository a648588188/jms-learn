/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.rabbitmq.hello;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p> 发送者 </p>
 *
 * <pre> Created: 2018/9/17 下午3:41  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class Send {

    /**
     * 队列名称
     */
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 2. 指定发送的队列及其信息
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        // 3. 关闭连接
        channel.close();
        connection.close();
    }

}
