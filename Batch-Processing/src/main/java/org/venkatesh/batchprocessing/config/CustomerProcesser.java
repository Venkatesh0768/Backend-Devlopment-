package org.venkatesh.batchprocessing.config;

import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.venkatesh.batchprocessing.model.Customer;

public class CustomerProcesser implements ItemProcessor<Customer , Customer> {
    @Override
    public Customer process(Customer item) throws Exception {
        return item;
    }
}
