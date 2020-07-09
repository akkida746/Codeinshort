package com.codeinshort.messagerouting.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Slf4j
@Component
public class JmsListener {

    @org.springframework.jms.annotation.JmsListener(destination = "inbound.queue")
    @SendTo("outbound.queue")
    public String receiveMsgAndMoveToAntherQueue(final Message msg) throws JMSException{
        log.info("Received Msg: " + msg);
        TextMessage textMessage = (TextMessage) msg;
        return "Received: " + textMessage.getText();
    }

    @org.springframework.jms.annotation.JmsListener(destination = "inbound.queue")
    public void receiveMsg(final Message msg) throws JMSException{
        TextMessage textMessage = (TextMessage) msg;
        log.info("Received msg: " + textMessage.getText());
    }
}
