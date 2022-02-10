package com.xl.kafka.interceptor;

import com.xl.kafka.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO-xule MessageConsumerInterpector
 *
 * @author xule
 * @since 2022-02-10 07:39
 */
@Component
@Slf4j
public class MessageConsumerInterceptor implements ConsumerInterceptor<Long, Message> {


    /**
     * 该方法会在KafkaConsumer的poll()返回之前被调用
     * @param consumerRecords
     * @return
     */
    @Override
    public ConsumerRecords<Long, Message> onConsume(ConsumerRecords<Long, Message> consumerRecords) {
        Iterable<ConsumerRecord<Long, Message>> records = consumerRecords.records("hello");
        for (ConsumerRecord<Long, Message> record : records) {
            Message message = record.value();
            message.setMsg("cousumer-" + message.getMsg());
        }
        return consumerRecords;
    }

    /**
     * 该方法会在KafkaConsumer提交完消费的offset之后被调用
     * @param map
     */
    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
//        map.forEach((tp,offset) -> log.info("tp:{},offset:{}",tp,offset.offset()));
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}