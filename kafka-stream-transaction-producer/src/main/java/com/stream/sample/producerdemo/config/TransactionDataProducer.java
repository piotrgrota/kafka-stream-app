package com.stream.sample.producerdemo.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionDataProducer {
        String TRANSACTIONS = "transaction";

        @Output(TRANSACTIONS)
        MessageChannel transactions();

}
