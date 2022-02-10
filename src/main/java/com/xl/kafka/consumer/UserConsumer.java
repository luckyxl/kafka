package com.xl.kafka.consumer;

import com.xl.kafka.message.Message;
import com.xl.kafka.message.User;
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
public class UserConsumer {




    @KafkaListener(topics = {"user"})
    public void listen(ConsumerRecord<String, User> record) {

        Optional.ofNullable(record.value())
                .ifPresent(user -> {
                    log.info("id:{},name:{},mobile:{}",user.getId(),user.getName(),user.getMobile());
                    log.info("【+++++++++++++++++ record = {} 】", record);
                    log.info("【+++++++++++++++++ user = {}】", user);
                });
    }
}