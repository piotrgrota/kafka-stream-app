package com.stream.sample.producerdemo.rest;

import com.stream.sample.producerdemo.config.TransactionDataProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProducerController {

    @Autowired
    TransactionDataProducer transactionProducer;

    @RequestMapping(value = "/producer/transaction", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE} ,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Map<String,String> produceTransaction(@RequestBody Transaction dto) {
        if(dto.getName() == null || dto.getName().isBlank()){
            return Map.of("status","error");
        }
        transactionProducer.transactions().send(MessageBuilder.withPayload(dto.getAmount())
                .setHeader(KafkaHeaders.MESSAGE_KEY, dto.getName()).build());

        return Map.of("status","ok");
    }
}
