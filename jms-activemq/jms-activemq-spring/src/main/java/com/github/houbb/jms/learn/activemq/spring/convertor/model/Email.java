/*
 * Copyright (c)  2018. houbinbin Inc.
 * jms All rights reserved.
 */

package com.github.houbb.jms.learn.activemq.spring.convertor.model;

import java.io.Serializable;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/9/21 上午11:59  </pre>
 * <pre> Project: jms  </pre>
 *
 * @author houbinbin
 */
public class Email implements Serializable {

    private static final long serialVersionUID = -209247729960531557L;

    private String receiver;
    private String title;
    private String content;

    public Email(String receiver, String title, String content) {
        this.receiver = receiver;
        this.title = title;
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "receiver='" + receiver + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
