package com.xl.kafka.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xl.kafka.message.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * TODO-xule Producer
 *
 * @author xule
 * @since 2022-02-07 16:58
 */
@Component
@Slf4j
@AllArgsConstructor
public class Producer {

    private KafkaTemplate<String, Message> kafkaTemplate;


    private Gson gson = new GsonBuilder().create();





    public void send(String msg) {




        Message message = Message.builder()
                .id(System.currentTimeMillis())
                .msg(msg)
                .sendTime(new Date())
                .build();


        log.info("【++++++++++++++++++ message ：{}】", gson.toJson(message));
        kafkaTemplate.send("hello",message.getId().toString(),message);


    }
}