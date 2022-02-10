package com.xl.kafka.interceptor;

import com.xl.kafka.message.Message;
import com.xl.kafka.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * TODO-xule ProducerInterceptor
 *
 * @author xule
 * @since 2022-02-08 11:25
 */
@Component
@Slf4j
public class FirstProducerInterceptor implements ProducerInterceptor<Long, Message> {


    /**
     * 该方法在消息序列化、计算分区前被调用
     * @param producerRecord
     * @return
     */
    @Override
    public ProducerRecord<Long, Message> onSend(ProducerRecord<Long, Message> producerRecord) {
        if (!Objects.equals("hello", producerRecord.topic())) {
            return producerRecord;
        }
        Message message = producerRecord.value();
        if (message != null) {
            message.setMsg("interceptor1-" + message.getMsg());
        }
        return producerRecord;
    }

    /**
     *该方法会在消息被应答（Acknowledgement(）之前，或者发送失败时调用
     * @param recordMetadata
     * @param e
     */
    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        log.info("recordMetadata is {}" , GsonUtil.toJsonStr(recordMetadata));
        log.info("Exception is {}" , GsonUtil.toJsonStr(e));
    }

    /**
     * 该方法主要用于在关闭拦截器时执行一些资源的清理工作
     */
    @Override
    public void close() {
        log.info("close....");
    }

    /**
     * 该方法主要用于获取kafka的配置信息
     * @param map
     */
    @Override
    public void configure(Map<String, ?> map) {
        log.info("config is {}" ,map);
    }

}