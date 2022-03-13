package com.example.airticketsorderservice.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Builder
public class OrderMessage {
    private String messageId;

    private String messageContent;
}
