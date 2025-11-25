package org.venkatesh.consumerkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.venkatesh.consumerkafka.util.AppConstant;

@SpringBootApplication
public class ConsumerKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerKafkaApplication.class, args);
    }


    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = "my-consumer-group")
    public void consume(String cxData) {
        System.out.println("Consumed message: " + cxData);
    }

}
