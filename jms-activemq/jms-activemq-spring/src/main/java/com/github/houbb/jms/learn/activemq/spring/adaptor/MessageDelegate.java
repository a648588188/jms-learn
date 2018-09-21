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
 * <pre> Created: 2018/9/21 上午11:15  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public interface MessageDelegate {

    void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    void handleMessage(Serializable message);

}
