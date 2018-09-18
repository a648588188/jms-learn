/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.rabbitmq.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/18 下午1:37  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        for(int i = 0; i < 8; i++) {
            String severity = getSeverity();
            String message = UUID.randomUUID().toString();

            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
            System.out.println(" [x] Sent '" + severity + "': '" + message + "'");
        }

        channel.close();
        connection.close();
    }

    /**
     * 随机一下一种日志级别
     * @return 日志级别
     */
    private static String getSeverity() {
        Random random = new Random();
        String[] strings = "trace,debug,info,warn,error".split(",");
        int randomIndex = random.nextInt(strings.length);
        return strings[randomIndex];
    }

}
