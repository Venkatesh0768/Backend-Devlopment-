package org.venkatesh.producerkafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.venkatesh.producerkafka.model.Customer;
import org.venkatesh.producerkafka.util.AppConstant;

@Service
public class CustomerService {

    private final KafkaTemplate<String , Customer> kafkaTemplate;

    public CustomerService(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String registerCx(Customer customer){
       kafkaTemplate.send(AppConstant.TOPIC_NAME , customer);
       return "Kafka producer is add on the Kafka Topic";
    }
}
