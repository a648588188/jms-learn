/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.rabbitmq.topic;

import com.rabbitmq.client.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/18 下午3:18  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv)
            throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        List<String> routingKeys = Arrays.asList("quick.orange.rabbit",
                "lazy.orange.elephant",
                "quick.orange.fox",
                "lazy.brown.fox",
                "lazy.pink.rabbit",
                "quick.brown.fox",
                "orange",
                "quick.orange.male.rabbit",
                "lazy.orange.male.rabbit");

        for(String routingKey : routingKeys) {
            String message = UUID.randomUUID().toString();

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }

        connection.close();
    }

}
