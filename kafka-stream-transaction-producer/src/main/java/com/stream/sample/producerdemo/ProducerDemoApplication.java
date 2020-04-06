package com.stream.sample.producerdemo;

import com.stream.sample.producerdemo.config.ProducerConfig;
import com.stream.sample.producerdemo.config.TransactionDataProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableBinding(TransactionDataProducer.class)
@Import({ProducerConfig.class})
public class ProducerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerDemoApplication.class, args);
	}

}
