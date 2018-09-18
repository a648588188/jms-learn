/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.rabbitmq.rpc;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/18 下午3:48  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class RpcClient {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";

    public RpcClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public String call(String message) throws IOException, InterruptedException {
        final String corrId = UUID.randomUUID().toString();

        String replyQueueName = channel.queueDeclare().getQueue();
        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

        String ctag = channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

        String result = response.take();
        channel.basicCancel(ctag);
        return result;
    }

    public void close() throws IOException {
        connection.close();
    }


    public static void main(String[] args) {
        RpcClient fibonacciRpc = null;
        String response = null;
        try {
            fibonacciRpc = new RpcClient();

            for (int i = 0; i < 32; i++) {
                String iStr = Integer.toString(i);
                System.out.println(" [x] Requesting fib(" + iStr + ")");
                response = fibonacciRpc.call(iStr);
                System.out.println(" [.] Got '" + response + "'");
            }
        }
        catch  (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if (fibonacciRpc!= null) {
                try {
                    fibonacciRpc.close();
                }
                catch (IOException _ignore) {}
            }
        }
    }

}
