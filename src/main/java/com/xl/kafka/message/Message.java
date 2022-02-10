package com.xl.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO-xule Message
 *
 * @author xule
 * @since 2022-02-07 16:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Long id;

    private String msg;

    private Date sendTime;
}