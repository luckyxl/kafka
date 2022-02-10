package com.xl.kafka.controller;

import com.xl.kafka.message.User;
import com.xl.kafka.producer.Producer;
import com.xl.kafka.producer.UserProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO-xule ApiController
 *
 * @author xule
 * @since 2022-02-07 17:00
 */
@RestController
@RequestMapping("kafka")
@AllArgsConstructor
public class ApiController {

    private Producer producer;
    private UserProducer userProducer;


    @GetMapping("send/{msg}")
    public void sendMessage(@PathVariable("msg") String msg){
        producer.send(msg);
    }


    @GetMapping("user")
    public void sendUser(User user){
        userProducer.send(user);
    }
}