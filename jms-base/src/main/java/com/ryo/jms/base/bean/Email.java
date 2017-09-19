package com.ryo.jms.base.bean;

import java.io.Serializable;

/**
 * @author houbinbin
 * @version 1.0
 * @on 2017/9/19
 * @since 1.7
 */
public class Email implements Serializable {

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
