package com.xl.kafka.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xl.kafka.message.Message;
import com.xl.kafka.message.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * TODO-xule Producer
 *
 * @author xule
 * @since 2022-02-07 16:58
 */
@Component
@Slf4j
@AllArgsConstructor
public class UserProducer {

    private KafkaTemplate<String, User> kafkaTemplate;


    private Gson gson = new GsonBuilder().create();





    public void send(User user) {




        user.setId(System.currentTimeMillis());


        log.info("【++++++++++++++++++ user ：{}】", gson.toJson(user));
        kafkaTemplate.send("user",user.getId().toString(),user);


    }
}