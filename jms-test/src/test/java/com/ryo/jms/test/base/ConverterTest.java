package com.ryo.jms.test.base;

import com.ryo.jms.base.bean.Email;
import com.ryo.jms.base.producer.ConverterProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-converter.xml")
public class ConverterTest {

    @Autowired
    private ConverterProducerService converterProducerService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void testSend() {
        Email email = new Email("zhangsan@xxx.com", "主题", "内容");
        converterProducerService.sendMessage(destination, email);
    }

}
