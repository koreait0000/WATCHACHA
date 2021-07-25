package com.spring.wachacha.pay.model;

import lombok.Data;

@Data
public class CallbackPayload {
    private String secret;
    private String status;
    private String orderId;
}
