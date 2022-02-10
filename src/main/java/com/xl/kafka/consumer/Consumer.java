package com.xl.kafka.consumer;

import com.xl.kafka.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * TODO-xule Consumer
 *
 * @author xule
 * @since 2022-02-07 16:59
 */
@Component
@Slf4j
public class Consumer {




    @KafkaListener(topics = {"hello"})
    public void listen(ConsumerRecord<String, Message> record) {

        Optional.ofNullable(record.value())
                .ifPresent(message -> {
                    log.info("id:{},sendTime:{},msg:{}",message.getId(),message.getSendTime(),message.getMsg());
                    log.info("【+++++++++++++++++ record = {} 】", record);
                    log.info("【+++++++++++++++++ message = {}】", message);
                });
    }
}